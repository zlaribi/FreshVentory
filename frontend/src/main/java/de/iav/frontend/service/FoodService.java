package de.iav.frontend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.iav.frontend.exception.CustomJsonProcessingException;
import de.iav.frontend.exception.CustomStatusCodeException;
import de.iav.frontend.model.Food;
import de.iav.frontend.model.FoodWithoutId;
import de.iav.frontend.security.AuthService;
import javafx.application.Platform;
import javafx.scene.control.TableView;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FoodService {
    public static final String COOKIE = "Cookie";
    public static final String JSESSIONID = "JSESSIONID=";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FOOD_BASE_URL = "http://localhost:8080/api/freshventory";
    private static final String HEADER_VAR = "application/json";

    private static FoodService instance;

    public FoodService() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static synchronized FoodService getInstance() {
        if (instance == null) {
            instance = new FoodService();
        }
        return instance;
    }


    private Food mapToFood(String json) {
        try {
            return objectMapper.readValue(json, Food.class);
        } catch (JsonProcessingException e) {
            throw new CustomJsonProcessingException("Failed to open food!", e);
        }
    }

    public List<Food> getFoodList() {
        HttpRequest request = HttpRequest.newBuilder().header(COOKIE, JSESSIONID + AuthService.getInstance().sessionId())
                .GET()
                .uri(URI.create(FOOD_BASE_URL + "/food"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::mapToFoodList)
                .join();
    }

    private List<Food> mapToFoodList(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new CustomJsonProcessingException("Failed to open food!", e);
        }
    }

    public void addFood(FoodWithoutId foodToAdd) {
        try {
            String requestBody = objectMapper.writeValueAsString(foodToAdd);
            HttpRequest request = HttpRequest.newBuilder().header(COOKIE, JSESSIONID + AuthService.getInstance().sessionId())
                    .uri(URI.create(FOOD_BASE_URL + "/food"))
                    .header("Content-Type", HEADER_VAR)
                    .header("Accept", HEADER_VAR)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToFood)
                    .join();
        } catch (JsonProcessingException e) {
            throw new CustomJsonProcessingException("Could not add food!", e);
        }
    }

    public void updateFoodById(String id, Food foodToAdd) {
        try {
            String requestBody = objectMapper.writeValueAsString(foodToAdd);
            HttpRequest request = HttpRequest.newBuilder().header(COOKIE, JSESSIONID + AuthService.getInstance().sessionId())
                    .uri(URI.create(FOOD_BASE_URL + "/" + id))
                    .header("Content-Type", HEADER_VAR)
                    .header("Accept", HEADER_VAR)
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToFood)
                    .join();
        } catch (JsonProcessingException e) {
            throw new CustomJsonProcessingException("Could not update food!", e);
        }
    }

    public void deleteFoodById(String idToDelete, TableView<Food> listView) {
        HttpRequest request = HttpRequest.newBuilder().header(COOKIE, JSESSIONID + AuthService.getInstance().sessionId())
                .uri(URI.create(FOOD_BASE_URL + "/" + idToDelete))
                .DELETE()
                .build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    if (response.statusCode() == 200) {
                        Platform.runLater(() -> {
                            listView.getItems().removeIf(food -> food.foodId().equals(idToDelete));
                            listView.refresh();
                            });
                        } else {
                        throw new CustomStatusCodeException("Error while deleting food with ID: " + idToDelete);
                        }
                    })
                    .join();
    }
}
