package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {


    List<Distillery> findAllDistilleryByRegion(String region);
}
