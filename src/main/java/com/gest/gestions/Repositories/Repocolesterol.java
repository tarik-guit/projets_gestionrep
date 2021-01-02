package com.gest.gestions.Repositories;

import com.gest.gestions.Entités.Cholesterol;
import com.gest.gestions.Entités.Data_personnelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repocolesterol extends JpaRepository<Cholesterol,Long> {



}
