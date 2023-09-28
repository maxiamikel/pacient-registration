package com.maxi.backpatient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maxi.backpatient.dtos.PatientDTO;
import com.maxi.backpatient.model.Patient;

@Service

public interface PatientService {

    public Patient addPatient(Patient patient);

    public Patient getPatientById(Long id);

    public Patient updatePatient(Long id, PatientDTO patientDTO);

    public List<Patient> getPatients();

    public void deletePatient(Long id);

}
