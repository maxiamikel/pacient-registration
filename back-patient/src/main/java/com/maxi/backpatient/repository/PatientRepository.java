package com.maxi.backpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backpatient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
