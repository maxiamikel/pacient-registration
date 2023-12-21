package com.maxi.backpatient.model;

import java.time.LocalDate;
import java.util.List;

import com.maxi.backpatient.enums.UserGender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "patient", uniqueConstraints = { @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "personalNumber") })
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "The personal number is required")
    private String personalNumber;

    @Email(message = "The email is incorrect")
    @NotBlank(message = "The email is required")
    private String email;

    @NotBlank(message = "The fone number is required")
    private String telephone;

    private UserGender gender;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Temporal(TemporalType.DATE)
    private LocalDate registDate;

    private String diagnosis;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "patient_consultation", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = {
            @JoinColumn(name = "consultation_id") })
    private List<Consultation> consultations;

    public Patient() {
    }

    public Patient(String name, String personalNumber, String email, String telephone, UserGender gender,
            LocalDate birthDate, String diagnosis) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.email = email;
        this.telephone = telephone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.diagnosis = diagnosis;
        this.registDate = LocalDate.now();
    }

    public Long getId() {
        return id;
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

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

}
