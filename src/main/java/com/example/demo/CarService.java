package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired; // для связи всех зависимостей в классах
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository repo;

    public List<Car> listAll(String keyword){
        if (keyword != null){
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Car car){
        repo.save(car);
    }

    public Car get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}