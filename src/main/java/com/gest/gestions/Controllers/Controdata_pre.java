package com.gest.gestions.Controllers;

import com.gest.gestions.Entités.Data_pre;
import com.gest.gestions.Entités.Hopital;
import com.gest.gestions.Entités.Patient;
import com.gest.gestions.Repositories.Repodata_pre;
import com.gest.gestions.Repositories.Repohopital;
import com.gest.gestions.Repositories.Repopatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class Controdata_pre {

    @Autowired
    private Repohopital reph;
    @Autowired
    private Repopatient repp;
    @Autowired
    private Repodata_pre repd;

    //pour les delets:

    @DeleteMapping("/data_pres")
    public String deleteall() {
        repd.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/data_pre/{id}")
    public String deletbyid(@PathVariable Long id) {
        repd.deleteById(id);
        return "supprimé";
    }
    //pour les gets :
    @GetMapping("/data_pres")
    public List<Data_pre> getall() {
        return repd.findAll();
    }


    @GetMapping("/data_pre/{id}")
    public Data_pre getbyiddata(@PathVariable Long id) {
        return repd.findById(id).get();
    }

    // get  liste data_pred par l'id d'un patient
    @GetMapping("/data_pre_for_p/{idp}")
    public List<Data_pre> getbyidpatient(@PathVariable Long idp) {
        return  repd.finddataforpatient(idp);
    }

    //pour les post:
    @PostMapping("/data_pre")
    public Data_pre creerdata_pre(@RequestBody Data_pre data_pre) {

        return  repd.save(data_pre);
    }
}
