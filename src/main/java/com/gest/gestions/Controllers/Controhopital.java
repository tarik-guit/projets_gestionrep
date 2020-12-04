package com.gest.gestions.Controllers;


import com.gest.gestions.Entités.Hopital;
import com.gest.gestions.Repositories.Repohopital;
import com.gest.gestions.Repositories.Repopatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class Controhopital {

    @Autowired
    private Repohopital reph;
    @Autowired
    private Repopatient repp;

    //pour les delets:

    @DeleteMapping("/hopitals")
    public String deleteall() {
        reph.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/hopital/{id}")
    public String deletbyid(@PathVariable Long id) {
        reph.deleteById(id);
        return "supprimé";
    }

    //pour les gets :
    @GetMapping("/hopitals")
    public List<Hopital> getall() {
        return reph.findAll();
    }


    @GetMapping("/hopital/{id}")
    public Hopital getbyid(@PathVariable Long id) {
        return reph.findById(id).get();
    }

    @GetMapping("/hopitalscurr")
    public List<Hopital> getallhopitalsforcurrentuser() {
        return reph.getallforcurrentuser("tarik");
    }

    //pour les post:
    @PostMapping("/hopital")
    public Hopital creerhopital(@RequestBody Hopital hopital) {

        return  reph.save(hopital);
    }
  //pour les put:
  @PutMapping("/hopital/{id}")
  public Hopital updatehopital(@PathVariable Long id, @RequestBody Hopital hop) {
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

      return reph.save(hopital);
  }
}


