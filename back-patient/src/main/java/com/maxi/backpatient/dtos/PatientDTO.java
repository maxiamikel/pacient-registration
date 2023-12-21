package com.maxi.backpatient.dtos;

import java.time.LocalDate;

import com.maxi.backpatient.enums.UserGender;
import com.maxi.backpatient.model.Patient;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class PatientDTO {
    private Long id;
    private String name;
    private String personalNumber;
    private String email;
    private String telephone;
    private UserGender gender;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Temporal(TemporalType.DATE)
    private LocalDate registDate;

    private String diagnosis;

    public PatientDTO() {
    }

    public PatientDTO(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.personalNumber = patient.getPersonalNumber();
        this.birthDate = patient.getBirthDate();
        this.email = patient.getEmail();
        this.telephone = patient.getTelephone();
        this.gender = patient.getGender();
        this.registDate = patient.getRegistDate();
        this.diagnosis = patient.getDiagnosis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegistDate() {
        return registDate;
    }

    public void setRegistDate(LocalDate registDate) {
        this.registDate = registDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

}
