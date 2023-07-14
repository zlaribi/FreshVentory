package de.iav.backend.service;

import de.iav.backend.model.Food;
import de.iav.backend.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> listAllFood(){
        return foodRepository.findAll();
    }

    public Food addFood(Food foodToAdd){
        return foodRepository.save(foodToAdd);
    }

    public Optional<Food> getFoodById(String foodId){
        return foodRepository.findById(foodId);
    }
    public void deleteFoodById(String foodId){
        foodRepository.deleteById(foodId);
    }
    public Food updateFoodById(String id, Food foodToUpdate){
        Optional<Food> existingFood = foodRepository.findById(id);
        if (existingFood.isPresent()) {
            return foodRepository.save(foodToUpdate);
        }
        throw new NoSuchElementException("Element with ID: " + id + " not found!");

    }



}
