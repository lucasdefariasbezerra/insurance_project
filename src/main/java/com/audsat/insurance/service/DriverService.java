package com.audsat.insurance.service;

import com.audsat.insurance.DTO.DriverDTO;
import com.audsat.insurance.model.Driver;
import com.audsat.insurance.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> handleDriverPersistence(List<DriverDTO> drivers) {
        List<Driver> persistedDrivers = new ArrayList<>();
        for (DriverDTO driver : drivers) {
            Driver persistedDriver = handleSingleDriverEntityPersistence(driver);
            persistedDriver.setMain(driver.getIsMain());
            persistedDrivers.add(persistedDriver);
        }
        return persistedDrivers;
    }

    public Driver handleSingleDriverEntityPersistence(DriverDTO driver) {
        boolean isAlreadyRegistered = driverRepository.countByDocument(driver.getDocument()) > 0;
        if (!isAlreadyRegistered) {
            Driver driverDB = new Driver(driver.getDocument(), driver.getBirthDate());
            return driverRepository.save(driverDB);
        }
        return driverRepository.findOneByDocument(driver.getDocument()).orElseThrow(IllegalArgumentException::new);
    }
}
