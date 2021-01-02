package com.gest.gestions.Controllers;


import com.gest.gestions.Entités.Cholesterol;
import com.gest.gestions.Entités.Data_pre;
import com.gest.gestions.Repositories.Repocolesterol;
import com.gest.gestions.Repositories.Repodata_pre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class Controcolesterol {

     @Autowired
     private Repocolesterol repc;
    @Autowired
    private Repodata_pre repd;

    //pour les delets:

    @DeleteMapping("/cholesterols")
    public String deleteall() {
        repc.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/cholesterole/{id}")
    public String deletbyid(@PathVariable Long id) {
        repc.deleteById(id);
        return "supprimé";
    }
    //pour les gets :
    @GetMapping("/cholesterols")
    public List<Cholesterol> getall() {
        return repc.findAll();
    }


    @GetMapping("/cholesterol/{id}")
    public Cholesterol getbyidd(@PathVariable Long id) {
        return repc.findById(id).get();
    }

    // get   cholesterol for data_pre
    @GetMapping("/cholesterol_for_datapre/{idp}")
    public Cholesterol getbyiddatapre(@PathVariable Long idp) {
        return  repd.findById(idp).get().getCholesterol();
    }

    //pour les post:
    //creer cholesterol
    @PostMapping("/cholesterol")
    public Cholesterol creercholesterol(@RequestBody Cholesterol cholesterol) {

        return  repc.save(cholesterol);
    }
    //creer cholesterol pour data_pre on donne l'id du data_pre

    @PostMapping("/cholesterol/{iddata}")
    public Cholesterol creercholesterolfordatapre(@RequestBody Cholesterol cholesterol,@PathVariable Long iddata) {
       Data_pre data_pre=repd.findById(iddata).get();
       data_pre.setCholesterol(cholesterol);
        return  repc.save(cholesterol);
    }
}
