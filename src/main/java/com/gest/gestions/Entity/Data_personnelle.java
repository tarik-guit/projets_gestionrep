package com.gest.gestions.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gest.gestions.jpaauditing.auditingclasse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Data_personnelle extends auditingclasse<String> implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String allergie;
    @Column
    private String antecedants;
    @JsonIgnore
    @ManyToOne(optional = true)
    private Patient patient;
    
    
	
    
    
    
    
    
  




}