package com.gest.gestions.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gest.gestions.Entity.Data_personnelle;
import com.gest.gestions.Entity.Data_pre;

import java.util.List;

@Repository
public interface RepoData_personnelle extends JpaRepository<Data_personnelle,Long> {

    @Query("SELECT n FROM Data_personnelle  n WHERE n.patient.id = :idp ")
    List<Data_personnelle> findDataForPatient(@Param("idp") Long idp);
}
