package de.iav.frontend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.iav.frontend.model.Food;
import de.iav.frontend.model.FoodWithoutId;
import javafx.application.Platform;
import javafx.scene.control.ListView;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FoodService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String FOOD_BASE_URL = "http://localhost:8080/api/freshventory";
    private final String header_var = "application/json";

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

    public Food getFoodById(String id) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(FOOD_BASE_URL + "/" + id))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::mapToFood)
                .join();
    }

    private Food mapToFood(String json) {
        try {
            return objectMapper.readValue(json, Food.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to open food!", e);
        }
    }

    public List<Food> getFoodList() {
        HttpRequest request = HttpRequest.newBuilder()
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
            return objectMapper.readValue(json, new TypeReference<List<Food>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to open food!", e);
        }
    }

    public Food addFood(FoodWithoutId foodToAdd) {
        try {
            String requestBody = objectMapper.writeValueAsString(foodToAdd);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(FOOD_BASE_URL + "/food"))
                    .header("Content-Type", header_var)
                    .header("Accept", header_var)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToFood)
                    .join();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Food updateFoodById(String id, Food foodToAdd) {
        try {
            String requestBody = objectMapper.writeValueAsString(foodToAdd);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(FOOD_BASE_URL + "/" + id))
                    .header("Content-Type", header_var)
                    .header("Accept", header_var)
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(this::mapToFood)
                    .join();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteFoodById(String idToDelete, ListView<Food> listView){
            HttpRequest request = HttpRequest.newBuilder()
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
                            throw new RuntimeException("Error while deleting food with ID: " + idToDelete);
                        }
                    })
                    .join();
    }
}
