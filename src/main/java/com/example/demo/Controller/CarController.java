package com.example.demo.Controller;

import com.example.demo.Entity.Car;
import com.example.demo.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    CarRepo carRepo;

    @GetMapping("/car-list")
    public List<Car> getAllCar(){
        return (List<Car>) carRepo.findAll();
    }

    @GetMapping("/car-search-brand/{model}")
    public List<Car> findByModel(@PathVariable String model){
        return carRepo.findByModel(model);

    }

    @GetMapping("car-search-price/{minPrice}/{maxPrice}")
    public List<Car> findBetweenPrice(@PathVariable int minPrice, @PathVariable int maxPrice){
        return carRepo.findByPriceBetween(minPrice, maxPrice);
    }

}
