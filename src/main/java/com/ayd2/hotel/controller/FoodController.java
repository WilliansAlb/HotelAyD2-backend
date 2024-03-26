package com.ayd2.hotel.controller;

import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.Food;
import com.ayd2.hotel.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("{foodId}")
    public ResponseEntity<Food> findById(@PathVariable("foodId") Long foodId) {
        return foodService.findById(foodId)
                .map(food -> new ResponseEntity<>(food, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Food>> findAll() {
        var food = foodService.findAll();
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> create(@RequestBody Food entity) {
        return new ResponseEntity<>(foodService.crete(entity), HttpStatus.CREATED);
    }

    @PutMapping("{foodId}")
    public ResponseEntity<Food> update(@PathVariable("foodId") Long foodId, @RequestBody Food entity) throws HtlException {
        var updatedFood = foodService.update(foodId, entity);
        return new ResponseEntity<>(updatedFood, HttpStatus.OK);
    }
}
