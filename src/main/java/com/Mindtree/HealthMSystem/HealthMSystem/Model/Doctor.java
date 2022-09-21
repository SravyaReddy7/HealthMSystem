package com.Mindtree.HealthMSystem.HealthMSystem.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Doctor {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;
	private String name;
	private String gender;
	private int age;
	private String specialization;
	private int numberOfPatients;
	public Doctor() {
		super();
		
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getNumberOfPatients() {
		return numberOfPatients;
	}
	public void setNumberOfPatients(int numberOfPatients) {
		this.numberOfPatients = numberOfPatients;
	}
	public Doctor(Integer doctorId, String name, String gender, int age, String specialization, int numberOfPatients) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.specialization = specialization;
		this.numberOfPatients = numberOfPatients;
	}

	
}
