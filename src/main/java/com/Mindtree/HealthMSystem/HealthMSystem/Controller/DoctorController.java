package com.Mindtree.HealthMSystem.HealthMSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mindtree.HealthMSystem.HealthMSystem.Model.Doctor;
import com.Mindtree.HealthMSystem.HealthMSystem.Service.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins="*")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	
	// add doctor
		@PostMapping("/add")
		public Doctor addDoctor(@RequestBody Doctor Doctor) {
			return doctorService.addDoctor(Doctor);
		}
		
		// get all doctor
		@GetMapping("/all")
		public List<Doctor> getAllDoctors() {
			return doctorService.getAllDoctors();
		}
		
		// get doctor by id
		@GetMapping("/{id}")
		public Doctor getDoctorById(@PathVariable("id") Integer id) {
			return doctorService.getDoctorById(id);
		}
}
