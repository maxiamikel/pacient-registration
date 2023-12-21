package com.maxi.backpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.backpatient.dtos.PatientDTO;
import com.maxi.backpatient.service.PatientServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @RequestMapping("/")
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/add")
    // @ApiOperation("")
    public String addPatient(@Valid @RequestBody PatientDTO patient) {
        patientServiceImpl.addPatient(patient);
        return "Patient added successfully";
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {
        return patientServiceImpl.getPatientById(id);

    }

    @GetMapping("/patients")
    public List<PatientDTO> getPatients() {
        return patientServiceImpl.findAll();
        // return null;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(patientServiceImpl.findAll());
    }

    @PutMapping("/update/{id}")
    @Modifying
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @Valid @RequestBody PatientDTO patient) {
        patientServiceImpl.updatePatient(patient.getId(), patient);
        return ResponseEntity.ok().body("Success");

    }

    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientServiceImpl.deletePatient(id);
        return "Patient deleted successfully";
    }

}
