package com.maxi.backpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.maxi.backpatient.model.Patient;
import com.maxi.backpatient.service.PatientServiceImpl;

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
    public String addPatient(@RequestBody Patient patient) {
        patientServiceImpl.addPatient(patient);
        return "Patient added successfully";
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientServiceImpl.getPatientById(id);
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientServiceImpl.getPatients();
    }

    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody PatientDTO patient) {
        return patientServiceImpl.updatePatient(patient.getId(), patient);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientServiceImpl.deletePatient(id);
        return "Patient deleted successfully";
    }

}
