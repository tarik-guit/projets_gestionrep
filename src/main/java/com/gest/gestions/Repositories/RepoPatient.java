package com.gest.gestions.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.gest.gestions.Entity.Cholesterol;
import com.gest.gestions.Entity.Patient;

import java.util.List;


@Repository
public interface RepoPatient extends JpaRepository<Patient,Long> {
    @Query("SELECT n FROM Patient  n WHERE n.hopital.id = :idp ")
    List<Patient> findpatientforhopital(@Param("idp") Long idp);
    
    
}
