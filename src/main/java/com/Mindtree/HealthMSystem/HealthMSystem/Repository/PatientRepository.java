package com.Mindtree.HealthMSystem.HealthMSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Mindtree.HealthMSystem.HealthMSystem.Model.Patient;


public interface PatientRepository extends JpaRepository<Patient,Integer>{

	
}
