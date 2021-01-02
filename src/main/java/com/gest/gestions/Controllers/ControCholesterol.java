package com.gest.gestions.Controllers;


import com.gest.gestions.Entity.Cholesterol;
import com.gest.gestions.Entity.Data_pre;
import com.gest.gestions.Entity.Patient;
import com.gest.gestions.Exception.ItemNotFoundException;
import com.gest.gestions.Repositories.RepoCholesterol;
import com.gest.gestions.Repositories.RepoData_pre;
import com.gest.gestions.Repositories.RepoPatient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cholesterol")
@CrossOrigin(origins ="*")
public class ControCholesterol {

    @Autowired
    private RepoCholesterol repc;
    @Autowired
    private RepoData_pre repd;
    @Autowired
    private RepoPatient patientService;

 
 
    
    //get all cholesterol data
    @GetMapping("/all")
    public List<Cholesterol> getall() {
        return repc.findAll();
    }


    @GetMapping("/{id}")
    public Cholesterol getById(@PathVariable Long id) {
    	Optional<Cholesterol> choles=repc.findById(id);
    	if(choles.isPresent()) {
        return choles.get();
    	}
    	else
    		throw new ItemNotFoundException("cholesterol with id "+id+" is not found");
        
    }
    
    // recupérer le cholesterol pour un patient
    @GetMapping("/cholesterolPredic/{idp}")
    public List<Cholesterol> getByDataPatient(@PathVariable Long idp) {
    	if(patientService.existsById(idp)) {
    	return repc.findByPatient_Id(idp);
    	}
    	else
    	{
    		throw new ItemNotFoundException("patient is not found , change ID"); 
    	}
    }

    //ajouter le bilan lipide(cholesterol)
    
    /* je pense qu'on va pas utiliser cette fonction !! */
    @PostMapping("/addCholesterol")
    public Cholesterol creercholesterol(@RequestBody Cholesterol cholesterol) {

        return  repc.save(cholesterol);
    }
   
    
    @PostMapping("/addCholesterol/{id}")
    public Cholesterol addCholesterol(@RequestBody Cholesterol cholesterol,@PathVariable Long id) {
    	if(patientService.existsById(id)) {
    	Patient patient=patientService.findById(id).get();
    	cholesterol.setPatient(patient);
    	Cholesterol choles=repc.saveAndFlush(cholesterol);
    	return choles;
    	}
    	else
    		throw new ItemNotFoundException("Patient is not found, change the Id "+id);
    	
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
    	if(repc.existsById(id)) {
        repc.deleteById(id);
        return "cholesterol n° "+id+" est supprimé";
    	}
    	else
    		throw new ItemNotFoundException("cholesterol ID is not found");
    }
    
}
