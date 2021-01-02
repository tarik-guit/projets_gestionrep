package com.gest.gestions.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gest.gestions.jpaauditing.auditingclasse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Hopital extends auditingclasse<String> implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private  String nom;
    @Column
    private String adresse;
    @Column
    private String info_supplementaire;
    @JsonIgnore
    @OneToMany(mappedBy = "hopital")
    private Set<Patient> patients=new HashSet<Patient>(0);
    

    
    
    
    
    
    

}
