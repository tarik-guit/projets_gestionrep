package com.gest.gestions.Repositories;

import com.gest.gestions.Entités.Data_pre;
import com.gest.gestions.Entités.Hopital;
import com.gest.gestions.Entités.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Repodata_pre extends JpaRepository<Data_pre,Long> {

    @Query("SELECT n FROM Data_pre  n WHERE n.patient.id = :idp ")
    List<Data_pre> finddataforpatient(@Param("idp") Long idp);

}
