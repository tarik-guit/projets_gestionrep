package com.gest.gestions.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gest.gestions.Entity.Hopital;

import java.util.List;

@Repository
public interface RepoHopital extends JpaRepository<Hopital,Long> {

    @Query("SELECT n FROM Hopital  n WHERE n.createdby=:username")
    List<Hopital> getallforcurrentuser(@Param("username") String username );
}
