package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GruzRepository extends JpaRepository<Gruz, Long> {
    @Query("SELECT p FROM Gruz p WHERE CONCAT(p.name_load, ' ', p.content, ' ', p.city_from , ' ', p.city_to, ' ', p.data_input, ' ', p.data_output) LIKE %?1%")
    List<Gruz> search(String keyword);


}