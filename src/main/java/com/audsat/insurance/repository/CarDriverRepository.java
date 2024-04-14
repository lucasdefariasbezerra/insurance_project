package com.audsat.insurance.repository;

import com.audsat.insurance.model.CarDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDriverRepository extends JpaRepository<CarDrive, Integer>{
}
