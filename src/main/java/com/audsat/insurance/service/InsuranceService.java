package com.audsat.insurance.service;

import com.audsat.insurance.DTO.BudgetReportDTO;
import com.audsat.insurance.DTO.CustomerDTO;
import com.audsat.insurance.DTO.DriverDTO;
import com.audsat.insurance.DTO.InsuranceDTO;
import com.audsat.insurance.model.*;
import com.audsat.insurance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarDriverRepository carDriverRepository;

    @Autowired
    private DriverService driverService;

    @Autowired
    private CarService carService;

    @Autowired
    private ClaimService claimService;


    public void registerInsurance(InsuranceDTO insurancePayload) {
        List<DriverDTO> drivers = insurancePayload.getDriverList();
        List<Driver> persistedDrivers = driverService.handleDriverPersistence(drivers);
        Customer persistedCustomer = handleCustomerPersistence(insurancePayload.getCustomer());
        Car persistedCar = carService.handleCarInsertion(insurancePayload.getCar());
        handleCarDriverAssociationPersistence(persistedDrivers, persistedCar);

        Insurance insuranceDB = new Insurance();
        insuranceDB.setActive(true);
        insuranceDB.setCar(persistedCar);
        insuranceDB.setCustomer(persistedCustomer);

        if (insurancePayload.getClaimList() != null && !insurancePayload.getClaimList().isEmpty()) {
            claimService.insertClaim(insurancePayload.getClaimList());
        }

        insuranceRepository.save(insuranceDB);
    }

    public BudgetReportDTO getCalculatedBudget(Integer id) {
        Insurance insurance = insuranceRepository.findOneById(id).orElseThrow(IllegalArgumentException::new);

        Double fipeValue = insurance.getCar().getFipeValue();
        Double finalVal = fipeValue * 0.06;
        finalVal += handleDriverAge(insurance, finalVal, fipeValue);
        handleClaims(insurance, finalVal, fipeValue);

        BudgetReportDTO reportDTO = new BudgetReportDTO();
        reportDTO.setCarModel(insurance.getCar().getModel());
        reportDTO.setCustomerName(insurance.getCustomer().getName());
        reportDTO.setFipeValue(insurance.getCar().getFipeValue());
        reportDTO.setInsurancePrice(finalVal);

        return reportDTO;
    }

    private double handleDriverAge(Insurance insurance, Double value, Double fipeValue) {
        CarDrive carDrive = carDriverRepository.findFirstByCarIdAndIsMainDriver(insurance.getCar().getId(), true);
        double finalValue = 0D;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(carDrive.getDriver().getBirthdate(), df);
        LocalDate current = LocalDate.now();
        Integer age = Period.between(birthDate, current).getYears();

        if (age >= 18 && age <= 25) {
            finalValue = value + (fipeValue * 0.02);
        }
        return finalValue;
    }

    private double handleClaims (Insurance insurance, Double value, Double fipeValue) {
        List<Driver> drivers = carDriverRepository.findByCarId(insurance.getCar().getId())
                .stream().map(CarDrive::getDriver)
                .toList();
        double finalVal = 0;

        if (claimService.isClaimFoundOnDrivers(drivers)) {
           finalVal = value + (fipeValue * 0.02);
        }

        if (claimService.isClaimFoundOnCar(insurance.getCar())) {
            finalVal +=  fipeValue * 0.02;
        }

        return finalVal;
    }

    private void handleCarDriverAssociationPersistence(List<Driver> persistedDrivers, Car persistedCar) {
        List<CarDrive> carDriveList = new ArrayList<>();
        for (Driver driver : persistedDrivers) {
            CarDrive carDrive = new CarDrive();
            carDrive.setDriver(driver);
            carDrive.setCar(persistedCar);
            carDrive.setMainDriver(driver.getMain());
            carDriveList.add(carDrive);
        }
        carDriverRepository.saveAll(carDriveList);
    }

    private Customer handleCustomerPersistence(CustomerDTO customer) {
        Customer customerDB = new Customer();
        customerDB.setName(customer.getName());

        Driver driverDB = driverService.handleSingleDriverEntityPersistence(customer);
        customerDB.setDriver(driverDB);

        return customerRepository.save(customerDB);
    }



}
