package com.maxi.backpatient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maxi.backpatient.dtos.PatientDTO;
import com.maxi.backpatient.model.Patient;

@Service

public interface PatientService {

    public Patient addPatient(PatientDTO patient);

    public PatientDTO getPatientById(Long id);

    // public Patient findtById(Long id);

    public void updatePatient(Long id, PatientDTO patientDTO);

    public List<PatientDTO> findAll();

    public void deletePatient(Long id);

}
