package com.gest.gestions.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gest.gestions.Entity.Cholesterol;
import com.gest.gestions.Entity.Data_personnelle;

@Repository
public interface RepoCholesterol extends JpaRepository<Cholesterol,Long> {
	
	List<Cholesterol> findByPatient_Id(Long id);
	
	



}
