package com.gest.gestions.Controllers;


import com.gest.gestions.Entités.Hopital;
import com.gest.gestions.Entités.Patient;
import com.gest.gestions.Repositories.Repohopital;
import com.gest.gestions.Repositories.Repopatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class Contropatient {

    @Autowired
    private Repohopital reph;
    @Autowired
    private Repopatient repp;
    //pour les delets:

    @DeleteMapping("/patients")
    public String deleteall() {
        repp.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/patient/{id}")
    public String deletbyid(@PathVariable Long id) {
        repp.deleteById(id);
        return "supprimé";
    }

    //pour les gets :
    @GetMapping("/patients_for_hop/{idh}")
    public List<Patient> getallpatientsforhopital(@PathVariable Long idh) {
        return repp.findpatientforhopital(idh);
    }


    @GetMapping("/patient/{id}")
    public Patient getbyid(@PathVariable Long id) {
        return repp.findById(id).get();
    }

    @GetMapping("/patients")
    public List<Patient> getallpatient() {
        return repp.findAll();
    }

    //pour les post:
    @PostMapping("/patient")
    public Patient creerpatient(@RequestBody Patient patient) {

        return  repp.save(patient);
    }
    //pour les put:
    @PutMapping("/patient/{id}")
    public Patient updatepatient(@PathVariable Long id, @RequestBody Patient hop) {
        Patient patient= repp.findById(id).get();
        if (hop.getPrenom() != null) {
            patient.setPrenom(hop.getNom());
        }
        if (hop.getNom() != null) {
            patient.setNom(hop.getNom());
        }

        if (hop.getNumcarte()!= patient.getNumcarte()) {
            patient.setNumcarte(hop.getNumcarte());
        }
        if (hop.getNbre_de_visites()!= patient.getNbre_de_visites()) {
            patient.setNbre_de_visites(hop.getNbre_de_visites());
        }


        return repp.save(patient);
    }
}
