package com.audsat.insurance.api;

import com.audsat.insurance.DTO.BudgetReportDTO;
import com.audsat.insurance.DTO.InsuranceDTO;
import com.audsat.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/insurance/budget")
public class InsuranceAPI {

    @Autowired
    private InsuranceService insuranceService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerInsurance(@RequestBody final InsuranceDTO insurancePayload) {
        try {
            insuranceService.registerInsurance(insurancePayload);
            return new ResponseEntity<>("insurance successfully registered", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>("error on registering insurance please contact server administrator", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{insuranceId}")
    public ResponseEntity<BudgetReportDTO> calculateInsuranceBudget(@PathVariable final Integer insuranceId) {
        return new ResponseEntity<>(insuranceService.getCalculatedBudget(insuranceId), HttpStatus.OK);
    }

}
