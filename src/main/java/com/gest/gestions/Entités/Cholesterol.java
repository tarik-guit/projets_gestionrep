package com.gest.gestions.Entités;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gest.gestions.jpaauditing.auditingclasse;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cholesterol extends auditingclasse<String> implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int hdl;
    @Column
    private int ldl;
    @Column
    private int triglycerides;
    @JsonIgnore
    @ManyToOne(optional = true)
    private Patient patient;
    @JsonIgnore
    @OneToOne(mappedBy = "cholesterol")
   // @JoinColumn(name = "cholesterol_data_pre")
    private Data_pre data_pre;

}
