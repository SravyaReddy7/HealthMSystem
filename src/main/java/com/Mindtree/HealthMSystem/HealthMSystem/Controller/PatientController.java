package com.Mindtree.HealthMSystem.HealthMSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mindtree.HealthMSystem.HealthMSystem.Model.Patient;
import com.Mindtree.HealthMSystem.HealthMSystem.Service.PatientService;




@RestController
@RequestMapping("patient")
@CrossOrigin(origins="*")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	// add patient
		@PostMapping("/add")
		public Patient addPatient(@RequestBody Patient patient) {
			return patientService.addPatient(patient);
		}
		
		// get patient by id
		@GetMapping("/{id}")
		public Patient getPatientById(@PathVariable("id") Integer id) {
			return patientService.getPatientById(id);
		}
}
