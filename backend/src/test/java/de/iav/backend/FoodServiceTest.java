package de.iav.backend;

import de.iav.backend.model.Food;
import de.iav.backend.repository.FoodRepository;
import de.iav.backend.service.FoodService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FoodServiceTest {

    FoodRepository foodRepository = mock(FoodRepository.class);
    FoodService foodService = new FoodService(foodRepository);

    @Test
    void getAllFood_whenFoodExist_theReturnFood() {
        //GIVEN
        List<Food> expectedListOfFood = List.of(
                new Food("5", "Zuccini", "2", "Vegetables", LocalDate.of(2022, 6, 2))
                , new Food("6", "yoghut", "1", "Milk products", LocalDate.of(2024, 12, 31))
                , new Food("7", "Chicken", "Meat", "1", LocalDate.of(2023, 8, 1)));
        when(foodRepository.findAll()).thenReturn(expectedListOfFood);
        //WHEN
        List<Food> actualListOfFood = foodService.listAllFood();
        //THEN
        assertEquals(expectedListOfFood, actualListOfFood);
        verify(foodRepository).findAll();
    }

}
