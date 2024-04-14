package com.audsat.insurance.service;

import com.audsat.insurance.DTO.CarDTO;
import com.audsat.insurance.DTO.ClaimDTO;
import com.audsat.insurance.DTO.DriverDTO;
import com.audsat.insurance.model.Car;
import com.audsat.insurance.model.Claim;
import com.audsat.insurance.model.Driver;
import com.audsat.insurance.repository.CarDriverRepository;
import com.audsat.insurance.repository.CarRepository;
import com.audsat.insurance.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private ClaimRepository claimRepository;

    public void insertClaim(List<ClaimDTO> claims) {
        List<Claim> itemsToPersist = new ArrayList<>();
        for (ClaimDTO claim : claims) {
            Driver driver = driverService.handleSingleDriverEntityPersistence(new DriverDTO(claim.getDriverDocument()));
            Car car = carService.handleCarInsertion(new CarDTO(claim.getCarId()));
           Claim claimDB = new Claim(driver, car, claim.getEventDate());
           itemsToPersist.add(claimDB);
       }
        claimRepository.saveAll(itemsToPersist);
    }

    public boolean isClaimFoundOnDrivers(List<Driver> drivers) {
        for (Driver driver : drivers) {
            int count = claimRepository.countByDriverDocument(driver.getDocument());
            if (count > 0)
                return true;
        }
        return false;
    }

    public boolean isClaimFoundOnCar(Car car) {
        int count = claimRepository.countByCarId(car.getId());
        return count > 0;
    }

}
