package com.gest.gestions.Controllers;

import com.gest.gestions.Entity.Cholesterol;
import com.gest.gestions.Entity.Data_pre;
import com.gest.gestions.Entity.Hopital;
import com.gest.gestions.Entity.Patient;
import com.gest.gestions.Exception.ItemNotFoundException;
import com.gest.gestions.Repositories.RepoCholesterol;
import com.gest.gestions.Repositories.RepoData_pre;
import com.gest.gestions.Repositories.RepoHopital;
import com.gest.gestions.Repositories.RepoPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/generalData")
@CrossOrigin(origins ="*")
public class ControDataPre {

    @Autowired
    private RepoHopital reph;
    @Autowired
    private RepoPatient repp;
    @Autowired
    private RepoData_pre repd;
    @Autowired
    private RepoCholesterol repCholes;


    //get all general data :
    @GetMapping("/all")
    public List<Data_pre> getall() {
        return repd.findAll();
    }


    @GetMapping("/{id}")
    public Data_pre getbyiddata(@PathVariable Long id) {
    	Data_pre data=repd.findById(id).orElseThrow(()-> new ItemNotFoundException("this prediction data is not found"));
        return data;
    }

    // get general data by patient_id
    @GetMapping("/data_patient/{idp}")
    public List<Data_pre> getByPatient_Id(@PathVariable Long idp) {
    	if(repp.existsById(idp)) {
        return  repd.finddataforpatient(idp);
    	}
    	else
    		throw new ItemNotFoundException("this patient is not found.");
    }

    //add new prediction data
    @PostMapping("/data_pre/{id}/{idc}")
    public ResponseEntity<?> addData(@RequestBody Data_pre data_pre,@PathVariable Long id,@PathVariable Long idc) {
    	if(repp.existsById(idc)) {
    	Patient patient=repp.findById(id).get();
    	data_pre.setPatient(patient);
    	Cholesterol choles=repCholes.findById(idc).get();
    	data_pre.setCholesterol(choles);
    	Data_pre data=repd.save(data_pre);
    	return new ResponseEntity<Long>(data.getId(),HttpStatus.OK);
    	}
    	else
    		throw new ItemNotFoundException("the patient with Id "+idc+" is not found");
    }
    
    //delete general data by Id
    @DeleteMapping("/data_pre/{id}")
    public String deletbyid(@PathVariable Long id) {
    	if(repp.existsById(id)) {
        repd.deleteById(id);
        return "general data n° "+id+" is deleted";
    	}
    	else
    		throw new ItemNotFoundException("we can't delete prediction data with Id "+id);
    }
}
