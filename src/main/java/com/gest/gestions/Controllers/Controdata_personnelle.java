package com.gest.gestions.Controllers;

import com.gest.gestions.Entités.Data_personnelle;
import com.gest.gestions.Entités.Data_pre;
import com.gest.gestions.Repositories.Repodata_personnelle;
import com.gest.gestions.Repositories.Repohopital;
import com.gest.gestions.Repositories.Repopatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class Controdata_personnelle {

    @Autowired
    private Repohopital reph;
    @Autowired
    private Repopatient repp;
    @Autowired
    private Repodata_personnelle repd;

    //pour les delets:

    @DeleteMapping("/data_personnelle")
    public String deleteall() {
        repd.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/data_personnelle/{id}")
    public String deletbyid(@PathVariable Long id) {
        repd.deleteById(id);
        return "supprimé";
    }
    //pour les gets :
    @GetMapping("/data_personnelle")
    public List<Data_personnelle> getall() {
        return repd.findAll();
    }


    @GetMapping("/data_personnelle/{id}")
    public Data_personnelle getbyiddata(@PathVariable Long id) {
        return repd.findById(id).get();
    }

    // get  liste data_pred par l'id d'un patient
    @GetMapping("/data_personnelle_for_p/{idp}")
    public List<Data_pre> getbyidpatient(@PathVariable Long idp) {
        return  repd.finddataforpatient(idp);
    }

    //pour les post:
    @PostMapping("/data_personnelle")
    public Data_personnelle creerdata_pre(@RequestBody Data_personnelle data_personelle) {

        return  repd.save(data_personelle);
    }
}
