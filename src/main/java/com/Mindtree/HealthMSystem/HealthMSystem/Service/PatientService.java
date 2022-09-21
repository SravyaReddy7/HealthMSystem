package com.Mindtree.HealthMSystem.HealthMSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mindtree.HealthMSystem.HealthMSystem.Model.Patient;
import com.Mindtree.HealthMSystem.HealthMSystem.Repository.PatientRepository;

@Service

public class PatientService {

	
	
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientRepository patientRepository;

	public Patient addPatient(Patient patient) {
		Patient newPatient =  patientRepository.save(patient);
		doctorService.updatePatientDoctor(newPatient.getDoctorId());
		return newPatient;
	}
	

	public Patient getPatientById(Integer id) {
		return patientRepository.findById(id).orElse(new Patient());
	}
}
