package com.Mindtree.HealthMSystem.HealthMSystem.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mindtree.HealthMSystem.HealthMSystem.Model.Doctor;
import com.Mindtree.HealthMSystem.HealthMSystem.Repository.DoctorRepository;


@Service
public class DoctorService {

	@Autowired
private DoctorRepository doctorRepository;
	
	public Doctor addDoctor(Doctor doc) {
		return doctorRepository.save(doc);
		
	}

	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctor getDoctorById(Integer id) {
		return doctorRepository.findById(id).orElse(new Doctor());
	}
	 

	public void updatePatientDoctor(Integer doctorId) {
		Doctor doc = doctorRepository.findById(doctorId).orElse(null);
		if(doc != null) {
			doc.setNumberOfPatients(doc.getNumberOfPatients()+1);
			doctorRepository.save(doc);
		}
	}

}
