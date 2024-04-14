package com.audsat.insurance.repository;

import com.audsat.insurance.model.CarDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDriverRepository extends JpaRepository<CarDrive, Integer>{

    CarDrive findFirstByCarIdAndIsMainDriver(Integer id, Boolean isMainDriver);
    List<CarDrive> findByCarId(Integer id);
}
