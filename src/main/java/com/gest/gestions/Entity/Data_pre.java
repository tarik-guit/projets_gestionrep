package com.gest.gestions.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gest.gestions.jpaauditing.auditingclasse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Data_pre  extends auditingclasse<String> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Long id;
//    @Column
//    private int  num_visite;
    @Column
    private int age;
    @Column
    private boolean sex;
    @Column
    private String chest_pain_type;
    @Column
    private int blood_pressure;

    @Column
    private boolean diabetique;

    @Column
    private int maximum_heart_rate;
    @Column
    private boolean angina;
    @Column
    private float poids;
    @Column
    private double taille;
    @Column
    private boolean fumeur;
//    @Column
//    private float classe;
    @JsonIgnore
    @ManyToOne(optional = true)
    private Patient patient;
    @JsonIgnore
    @OneToOne
    private Cholesterol cholesterol;

    @Column
    private Date datevisite= new Date();

	
	
	
    
    
   
    
}
