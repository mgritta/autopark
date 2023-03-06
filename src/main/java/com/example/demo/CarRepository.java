package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT p FROM Car p WHERE CONCAT(p.mark, ' ', p.release_date, ' ', p.register_date, ' ', p.owner) LIKE %?1%")
    List<Car> search(String keyword);


}