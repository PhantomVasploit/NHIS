package com.phantomLabs.nhis.controller;

import com.phantomLabs.nhis.entity.Patient;
import com.phantomLabs.nhis.error.RegisteredMailException;
import com.phantomLabs.nhis.model.PatientModel;
import com.phantomLabs.nhis.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody PatientModel patientModel) throws RegisteredMailException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/api/patient/register").toUriString());
        return ResponseEntity.created(uri).body(patientService.registerPatient(patientModel));
    }
}
