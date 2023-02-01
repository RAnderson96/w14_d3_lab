package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findAllByYear(int year);

    List<Whisky> findByDistilleryNameAndAge(String distillery_name, int age);


    List<Whisky> findAllByDistilleryRegion(String region);

}
