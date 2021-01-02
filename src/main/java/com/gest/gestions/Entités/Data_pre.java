package com.gest.gestions.Entités;


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

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int  num_visite;
    @Column
    private float age;
    @Column
    private float sex;
    @Column
    private float chest_pain_type;
    @Column
    private float blood_pressure;

    @Column
    private int diabetique;

    @Column
    private float maximum_heart_rate;
    @Column
    private float angina;
    @Column
    private float poids;
    @Column
    private float taille;
    @Column
    private int fumeur;
    @Column
    private float classe;
    @JsonIgnore
    @ManyToOne(optional = true)
    private Patient patient;
    @JsonIgnore
    @OneToOne
    private Cholesterol cholesterol;

    @Column
    private Date datevisite= new Date();
}
