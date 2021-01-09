package com.gest.gestions.Controllers;


import com.gest.gestions.Entity.Hopital;
import com.gest.gestions.Entity.Patient;
import com.gest.gestions.Exception.ItemNotFoundException;
import com.gest.gestions.Repositories.RepoHopital;
import com.gest.gestions.Repositories.RepoPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins ="*")
public class ControlPatient {

    @Autowired
    private RepoHopital reph;
    @Autowired
    private RepoPatient repp;
  

  

    //get all patients for an hospital
    @GetMapping("/patient_hospital/{idh}")
    public List<Patient> getallpatientsforhopital(@PathVariable Long idh) {
    	if(reph.existsById(idh)) {
        return repp.findpatientforhopital(idh);
    	}
    	else
    		throw new ItemNotFoundException("Hospital with Id "+idh+" is not found");
    }


    //get patient by Id
    @GetMapping("/{id}")
    public Patient getbyid(@PathVariable Long id) {
    	if(!repp.existsById(id)) {
    		throw new ItemNotFoundException("patient id "+id+" is not found");
    	}
    	else
        return repp.findById(id).get();
    }

    //get all patients
    @GetMapping("/all")
    public List<Patient> getallpatient() {
        return  repp.findAll();
    }

    //add a patient
    @PostMapping("/hospital/{id}")
    public Patient creerpatient(@RequestBody Patient patient,@PathVariable Long id) {
    	if(reph.existsById(id)) {
    	Hopital hopital =reph.findById(id).get();
    	patient.setHopital(hopital);
        return repp.saveAndFlush(patient);

      //  return new ResponseEntity<String>("a new patient is created",HttpStatus.OK);
    	}
    	else 
    		throw new ItemNotFoundException("Hospital with id "+id+" is not found");
    }
    
    
    //to update a patient
    @PutMapping("/updatePatient/{id}")
    public Patient updatepatient(@PathVariable Long id, @RequestBody Patient hop) {
    	if(repp.existsById(id)) {
        Patient patient= repp.findById(id).get();
        if (hop.getPrenom() != null) {
            patient.setPrenom(hop.getPrenom());
        }
        if (hop.getNom() != null) {
            patient.setNom(hop.getNom());
        }

        if (hop.getNumcarte()!= patient.getNumcarte()) {
            patient.setNumcarte(hop.getNumcarte());
        }
        
        if (hop.getAdresse()!= patient.getAdresse()) {
            patient.setAdresse(hop.getAdresse());
        }
        if (hop.getNbre_de_visites()!= patient.getNbre_de_visites()) {
            patient.setNbre_de_visites(hop.getNbre_de_visites());
        }
        return repp.saveAndFlush(patient);
    	}
    	else
    		throw new ItemNotFoundException("this patient is not found, try with another Id");
    }
    
    //delete patient by Id
    @DeleteMapping("/{id}")
    public String deletbyid(@PathVariable Long id) {
    	if(repp.existsById(id)) {
        repp.deleteById(id);
        return "patient n° "+id+" is deleted";
    	}
    	else
    		throw new ItemNotFoundException("this patient is not found, we can't delete it");
    }
}
