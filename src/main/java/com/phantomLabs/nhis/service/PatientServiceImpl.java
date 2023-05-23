package com.phantomLabs.nhis.service;

import com.phantomLabs.nhis.entity.Patient;
import com.phantomLabs.nhis.error.PatientNotFoundException;
import com.phantomLabs.nhis.error.RegisteredMailException;
import com.phantomLabs.nhis.model.PatientModel;
import com.phantomLabs.nhis.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public Patient registerPatient(PatientModel patientModel) throws RegisteredMailException {
        Optional<Patient> registeredPatient = Optional.ofNullable(patientRepository.findByEmail(patientModel.getEmail()));
        if(registeredPatient.isPresent())
        {
            throw new RegisteredMailException("Email is already registered");
        }
        Patient patient = new Patient();
        patient.setFirstName(patientModel.getFirstName());
        patient.setLastName(patientModel.getLastName());
        patient.setEmail(patientModel.getEmail());
        patient.setDateOfBirth(patientModel.getDateOfBirth());
        patient.setAddress(patientModel.getAddress());
        patient.setGender(patientModel.getGender());
        patient.setPhoneNumber(patientModel.getPhoneNumber());
        patient.setPassword(passwordEncoder.encode(patientModel.getPassword()));
        log.info("Patient account created successfully");
        return patientRepository.save(patient);
    }

    @Override
    public Patient login() {
        return null;
    }

    @Override
    public Patient findByEmail(String email) {
        return null;
    }

    @Override
    public Patient findByPatientId(Long patientId) throws PatientNotFoundException {
        Optional<Patient> patient = Optional.ofNullable(patientRepository.findByPatientId(patientId));
        if(!patient.isPresent())
        {
            throw new PatientNotFoundException("No patient record with that id");
        }
        return patient.get();
    }

    @Override
    public Patient updatePatientAccount(PatientModel patientModel) {
        return null;
    }

    @Override
    public void deletePatientAccount(String email) {

    }
}
