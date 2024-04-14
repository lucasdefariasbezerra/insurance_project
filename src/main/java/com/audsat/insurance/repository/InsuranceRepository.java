package com.audsat.insurance.repository;

import com.audsat.insurance.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    Optional<Insurance> findOneById(Integer id);
}
