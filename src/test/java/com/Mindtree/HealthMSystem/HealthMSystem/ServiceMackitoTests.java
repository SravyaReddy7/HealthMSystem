package com.Mindtree.HealthMSystem.HealthMSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Mindtree.HealthMSystem.HealthMSystem.Model.Doctor;
import com.Mindtree.HealthMSystem.HealthMSystem.Model.Patient;
import com.Mindtree.HealthMSystem.HealthMSystem.Repository.DoctorRepository;
import com.Mindtree.HealthMSystem.HealthMSystem.Repository.PatientRepository;
import com.Mindtree.HealthMSystem.HealthMSystem.Service.DoctorService;
import com.Mindtree.HealthMSystem.HealthMSystem.Service.PatientService;

@SpringBootTest(classes= {ServiceMackitoTests.class})
public class ServiceMackitoTests {


	@Mock
	DoctorRepository doctorRepository;
	@Mock
	PatientRepository patientRepository;
	
	@InjectMocks
	DoctorService doctorService;
	
	@Mock
	DoctorService doctorService2;
	@InjectMocks
	PatientService patientService;
	
	public List<Doctor> mydoctors;
	public List<Patient> mypatients;
	
	
	@Test
	@Order(1)
	public void test_getAllDoctors()
	{
		List<Doctor> mydoctors=new ArrayList<Doctor>();
		mydoctors.add(new Doctor(1,"Sravya","Female",22,"Cardiologist",9));
		mydoctors.add(new Doctor(2,"Bhanu","Female",22,"Dermitologist",9));
		when(doctorRepository.findAll()).thenReturn(mydoctors);//Mocking
		List<Doctor> allDoctors = doctorService.getAllDoctors();
	}
	
	@Test
	@Order(2)
	public void test_addDoctor()
	{
		Doctor doctor=new Doctor(3,"BhanuSri","Female",22,"Neurologist",9);
		when (doctorRepository.save(any())).thenReturn(doctor);
		assertEquals(doctor,doctorService.addDoctor(doctor));
	}
	
	@Test
	@Order(3)
	public void test_getDoctorByid()
	{
		Doctor doctor = new Doctor(2,"Bhanu","Female",22,"Dermitologist",9);
		when(doctorRepository.findById(2)).thenReturn(Optional.of(doctor));//Mocking
		Doctor doctorById = doctorService.getDoctorById(2);
		assertEquals(2,doctorService.getDoctorById(2).getDoctorId());
	}
	
	@Test
	@Order(4)
	public void test_addPatient()
	{
		Patient patient=new Patient(3,"BhanuSri","Sravya",1,"20-09-2022","omeg");
		when (patientRepository.save(any())).thenReturn(patient);
		Patient actual = patientService.addPatient(patient);
		assertEquals(patient.getDoctorId(),actual.getDoctorId());
	}
	
	@Test
	@Order(5)
	public void test_getPatientByid()
	{
		Patient patient=new Patient(3,"divya","Dr.Hyma",6,"18-09-2022","null");
		int patientid=3;
		when(patientRepository.findById(3)).thenReturn(Optional.of( patient));//Mocking
		assertEquals(3,patientService.getPatientById(patientid).getPatientId());
	}
}


