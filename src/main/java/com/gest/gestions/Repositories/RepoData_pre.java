package com.gest.gestions.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gest.gestions.Entity.Cholesterol;
import com.gest.gestions.Entity.Data_pre;
import com.gest.gestions.Entity.Hopital;
import com.gest.gestions.Entity.Patient;

import java.util.List;
import java.util.Optional;
@Repository
public interface RepoData_pre extends JpaRepository<Data_pre,Long> {

    @Query("SELECT n FROM Data_pre  n WHERE n.patient.id = :idp ")
    List<Data_pre> finddataforpatient(@Param("idp") Long idp);
    
    Cholesterol findByCholesterol_Id(Long id);

}
