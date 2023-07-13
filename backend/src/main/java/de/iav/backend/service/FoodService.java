package de.iav.backend.service;

import de.iav.backend.model.Food;
import de.iav.backend.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> listAllFood(){
        return foodRepository.findAll();
    }

    public Food addFood(Food foodToAdd){
        return foodRepository.save(foodToAdd);
    }

}
