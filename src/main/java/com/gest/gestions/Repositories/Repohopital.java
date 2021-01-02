package com.gest.gestions.Repositories;

import com.gest.gestions.Entités.Hopital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repohopital extends JpaRepository<Hopital,Long> {

    @Query("SELECT n FROM Hopital  n WHERE n.createdby=:username")
    List<Hopital> getallforcurrentuser(@Param("username") String username );
}
