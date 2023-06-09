package com.phantomLabs.nhis.repository;

import com.phantomLabs.nhis.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Patient findByEmail(String email);
    public Patient findByPatientId(Long patientId);
}
