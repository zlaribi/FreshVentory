package de.iav.backend.controller;

import de.iav.backend.model.Food;
import de.iav.backend.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/foodventory")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public List<Food> listAllFood(){
        return foodService.listAllFood();
    }
    @PostMapping("/foods")
    public Food addFood(@RequestBody Food foodToAdd){
        return foodService.addFood(foodToAdd);
    }

    @GetMapping("/{id}")
    public Optional<Food> getFoodById(@PathVariable String id){
        return foodService.getFoodById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteFoodById(@PathVariable String id){
        foodService.deleteFoodById(id);
    }
    @PutMapping("/{id}")
    public Food updateFoodById(@PathVariable String id, @RequestBody Food foodToUpdate){
        return foodService.updateFoodById(id, foodToUpdate);
    }
}
