package com.ayd2.hotel.service;

import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.Food;
import com.ayd2.hotel.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public Optional<Food> findById(Long foodId) {
        return foodRepository.findById(foodId);
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food crete(Food entity) {
        return foodRepository.save(entity);
    }

    public Food update(Long foodId, Food entity) throws HtlException {
        var foodOpt = foodRepository.findById(foodId);
        if (foodOpt.isEmpty()) throw new HtlException("food_not_found")
                .status(HttpStatus.NOT_FOUND);

        if (foodId.equals(foodOpt.get().getFoodId())) throw new HtlException("invalid_update");

        return foodRepository.save(entity);
    }
}
