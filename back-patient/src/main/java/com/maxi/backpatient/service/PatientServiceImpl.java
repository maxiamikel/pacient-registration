package com.maxi.backpatient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backpatient.dtos.PatientDTO;
import com.maxi.backpatient.model.Patient;
import com.maxi.backpatient.repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository repo;

    @Override
    public Patient addPatient(Patient patient) {

        return repo.saveAndFlush(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = repo.findById(id);
        return patient.orElseThrow(() -> new RuntimeException("Id not found"));
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> list = repo.findAll();
        return list;
    }

    @Override
    public void deletePatient(Long id) {
        getPatientById(id);
        repo.deleteById(id);
    }

    @Override
    public Patient updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient = getPatientById(id);
        if (!patient.getPersonalNumber().equals(patientDTO.getPersonalNumber())) {
            throw new RuntimeException("The Personal ID is incorrect");
        } else {
            patient.setName(patientDTO.getName());
            patient.setEmail(patientDTO.getEmail());
            patient.setTelephone(patientDTO.getTelephone());
            return repo.save(patient);
        }
    }

    // 44988319197

}
