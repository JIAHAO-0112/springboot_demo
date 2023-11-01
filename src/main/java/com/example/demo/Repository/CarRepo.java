package com.example.demo.Repository;

import com.example.demo.Entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CarRepo extends CrudRepository<Car, Long> {
    List<Car> findByModel(String model);

    List<Car> findByPriceBetween(int minPrice, int maxPrice);
}
