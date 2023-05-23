package com.phantomLabs.nhis.service;

import com.phantomLabs.nhis.entity.Patient;
import com.phantomLabs.nhis.error.PatientNotFoundException;
import com.phantomLabs.nhis.error.RegisteredMailException;
import com.phantomLabs.nhis.model.PatientModel;

public interface PatientService {
    public Patient registerPatient(PatientModel patientModel) throws RegisteredMailException;
    public Patient login();
    public Patient findByEmail(String email);
    public Patient findByPatientId(Long patientId) throws PatientNotFoundException;
    public Patient updatePatientAccount(PatientModel patientModel);
    public void deletePatientAccount(String email);
}
