package com.gest.gestions.Controllers;


import com.gest.gestions.Entity.Hopital;
import com.gest.gestions.Exception.ItemNotFoundException;
import com.gest.gestions.Repositories.RepoHopital;
import com.gest.gestions.Repositories.RepoPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/hospital")

public class ControlHopital {

    @Autowired
    private RepoHopital reph;
    @Autowired
    private RepoPatient repp;
 
    

    //get all hoqpitals
    @GetMapping("/hopitals")
    public List<Hopital> getall() {
        return reph.findAll();
    }

    //get hospital by Id
    @GetMapping("/{id}")
    public Hopital getbyid(@PathVariable Long id) {
    	if(reph.existsById(id)) {
        return reph.findById(id).get();
    	}
    	else
    		throw new ItemNotFoundException("Hospital with Id "+id+" is not found");
    }

    
    @GetMapping("/hopitalscurr")
    public List<Hopital> getallhopitalsforcurrentuser() {
        return reph.getallforcurrentuser("mahdia & tarik & amine ");
    }

    //add an hospital
    @PostMapping("/hopital")
    public Hopital creerHopital(@RequestBody Hopital hopital) {
      return reph.save(hopital);

    }
    
  //modify informations of an hospital
  @PutMapping("/hopital/{id}")
  public Hopital updatehopital(@PathVariable Long id, @RequestBody Hopital hop) {
	  if(reph.existsById(id)) {
      Hopital hopital= reph.findById(id).get();
      
      if (hop.getNom() != null) {
          hopital.setNom(hop.getNom());
      }

      if (hop.getAdresse()!= null) {
          hopital.setAdresse(hop.getAdresse());
      }
      if (hop.getInfo_supplementaire() != null) {
          hopital.setInfo_supplementaire(hop.getInfo_supplementaire());
      }

      return reph.saveAndFlush(hopital);
	  }
	  else
		  throw new ItemNotFoundException("Hopistal is not found , try to change the Id "+id);
  }
  
  
  //delete hospital by Id
  @DeleteMapping("/hopital/{id}")
  public String deletbyid(@PathVariable Long id) {
	  if(reph.existsById(id)) {
      reph.deleteById(id);
      return "hospital n° "+id+" is deleted";
	  }
	  else
		  throw new ItemNotFoundException("we can't delete an hospital with Id "+id );
  }
}


