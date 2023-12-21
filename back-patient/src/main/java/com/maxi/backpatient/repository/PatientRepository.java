package com.maxi.backpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maxi.backpatient.model.Patient;

import jakarta.transaction.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.email =:email")
    List<Patient> findByEmail(String email);

    @Query("SELECT p FROM Patient p WHERE p.personalNumber =:pno")
    List<Patient> findByPersonalNumber(String pno);

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.name= :name, p.telephone = :telephone, p.email = :email WHERE p.id = :id")
    public void utdatePatient(@Param("name") String name, @Param("email") String email,
            @Param("telephone") String telephone, @Param("id") Long id);

}
