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

public class Patient extends auditingclasse<String> implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private  String prenom;
    
    @Column
    private  String nom;
    
    @Column
    private  String numcarte;
    
    @Column
    private  int nbre_de_visites;
    
    @Column 
    private String adresse;
    
    @JsonIgnore
    @ManyToOne(optional = true)
    private Hopital hopital;
    
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<Data_pre> data_pres=new HashSet<Data_pre>(0);
    
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<Data_personnelle> data_personelles=new HashSet<Data_personnelle>(0);
    
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<Cholesterol> cholesterols=new HashSet<Cholesterol>(0);
    
    
    
	
    
    


}
