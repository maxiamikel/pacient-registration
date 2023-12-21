package com.maxi.backpatient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backpatient.dtos.PatientDTO;
import com.maxi.backpatient.model.Patient;
import com.maxi.backpatient.repository.PatientRepository;
import com.maxi.backpatient.service.exceptions.ConflictCreattigException;
import com.maxi.backpatient.service.exceptions.EntityNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository repo;

    @Override
    public Patient addPatient(PatientDTO patient) {

        List<Patient> listEmail = repo.findByEmail(patient.getEmail());
        List<Patient> listPno = repo.findByPersonalNumber(patient.getPersonalNumber());

        if (listEmail.size() > 0) {
            throw new ConflictCreattigException(
                    "The informated email was be used by another user in the system, try with another");
        } else if (listPno.size() > 0) {
            throw new ConflictCreattigException(
                    "The informated PNO was be used by another user in the system, try with another");
        } else {
            Patient obj = new Patient(patient.getName(), patient.getPersonalNumber(), patient.getEmail(),
                    patient.getTelephone(), patient.getGender(), patient.getBirthDate(), patient.getDiagnosis());
            return repo.saveAndFlush(obj);
        }

    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Optional<Patient> obj = repo.findById(id);
        if (obj.isPresent()) {
            PatientDTO objDTO = new PatientDTO();
            objDTO.setId(obj.get().getId());
            objDTO.setName(obj.get().getName());
            objDTO.setPersonalNumber(obj.get().getPersonalNumber());
            objDTO.setBirthDate(obj.get().getBirthDate());
            objDTO.setEmail(obj.get().getEmail());
            objDTO.setGender(obj.get().getGender());
            objDTO.setTelephone(obj.get().getTelephone());
            objDTO.setRegistDate(obj.get().getRegistDate());
            objDTO.setDiagnosis(obj.get().getDiagnosis());
            return objDTO;
        } else {
            throw new EntityNotFoundException("The entity informated ID [" + id + "] is not present");
        }
    }

    @Override
    public void deletePatient(Long id) {
        getPatientById(id);
        repo.deleteById(id);
    }

    @Override
    public List<PatientDTO> findAll() {
        List<Patient> list = repo.findAll();
        List<PatientDTO> listDTO = list.stream().map(obj -> new PatientDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    @Override
    public void updatePatient(Long id, PatientDTO patientDTO) {
        PatientDTO patient = getPatientById(id);
        if (patient != null && patient.getPersonalNumber().equals(patientDTO.getPersonalNumber())) {
            repo.utdatePatient(patientDTO.getName(), patientDTO.getEmail(), patientDTO.getTelephone(), id);
        } else {
            throw new EntityNotFoundException("The informated ID [" + id + "] is not correspond to the PNO ["
                    + patientDTO.getPersonalNumber() + " ]");
        }
    }
}
