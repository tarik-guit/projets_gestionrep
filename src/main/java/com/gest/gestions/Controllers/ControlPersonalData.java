package com.gest.gestions.Controllers;

import com.gest.gestions.Entity.Data_personnelle;
import com.gest.gestions.Entity.Data_pre;
import com.gest.gestions.Entity.Patient;
import com.gest.gestions.Exception.ItemNotFoundException;
import com.gest.gestions.Repositories.RepoData_personnelle;
import com.gest.gestions.Repositories.RepoHopital;
import com.gest.gestions.Repositories.RepoPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personnelle")
@CrossOrigin(origins ="*")
public class ControlPersonalData {

    @Autowired
    private RepoHopital reph;
    @Autowired
    private RepoPatient repp;
    @Autowired
    private RepoData_personnelle repd;



  
    //get all personal datas
    @GetMapping("/all")
    public List<Data_personnelle> getall() {
        return repd.findAll();
    }

    // get personal data by Id
    @GetMapping("/{id}")
    public Data_personnelle getbyiddata(@PathVariable Long id) {
    	Optional<Data_personnelle> data=repd.findById(id);
        return repd.findById(id).orElseThrow(()->new ItemNotFoundException("personal data is not found with this Id"));
    }

    
    // get personal data of patient by PatientId
    @GetMapping("/personal_patient/{idp}")
    public List<Data_personnelle> getbyidpatient(@PathVariable Long idp) {
    	if(repp.existsById(idp)) {
        return  repd.findDataForPatient(idp);
    	}
    	else
    		throw new ItemNotFoundException("patient with id "+idp+" is not found");
    }

    //To add a new personal data for a patient
    @PostMapping("/addPersonal/{idPatient}")
    public Data_personnelle creerdata_pre(@RequestBody Data_personnelle data_personelle,@PathVariable Long idPatient) {
    	
    	Patient pt =repp.findById(idPatient).get();
    	data_personelle.setPatient(pt);

        return  repd.save(data_personelle);
    }
    
    //delete by Id
    @DeleteMapping("/data_personnelle/{id}")
    public String deletbyid(@PathVariable Long id) {
    	if(repd.existsById(id)) {
        repd.deleteById(id);
        return "personal data n° "+id+ " is deleted";
    	}
    	else
    		throw new ItemNotFoundException("we can't delete data with ID "+id);
    }

 
}
