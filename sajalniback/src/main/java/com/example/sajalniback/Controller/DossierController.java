package com.example.sajalniback.Controller;

import com.example.sajalniback.Repository.DossierRepository;
import com.example.sajalniback.Repository.HistoriqueRepository;
import com.example.sajalniback.exception.UserNotFoundException;
import com.example.sajalniback.model.Demande;
import com.example.sajalniback.model.Dossier;
import com.example.sajalniback.model.Historique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dossier")
public class DossierController {
    @Autowired
    private DossierRepository dosrepo;

    @Autowired
    private HistoriqueRepository hrepo;

    //list
    @RequestMapping("/all")
    public List<Dossier> getAllDos() {
        return dosrepo.findAll();
    }

    //mylist
    @RequestMapping("/myall")
    public List<Dossier> getmyAllDos() {

        return dosrepo.findByUser(RegistController.currentUser);
    }


    //detail
    @GetMapping("/find/{id}")
    public ResponseEntity<Dossier> getdosById(@PathVariable(value = "id") Long id)
            throws UserNotFoundException {
        Dossier dos = dosrepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("le dossier avec l'id: " + id+" n'existe pas"));
        return ResponseEntity.ok().body(dos);
    }

    //ajout
    @PostMapping("/add")
    public Dossier createDos(@RequestBody Dossier dos) {
        dos.setStatut("en_cours");
        dos.setUser(RegistController.currentUser);
        Historique h = new Historique();
        h.setDossier(dos);
        h.setIntervenant(RegistController.currentUser.getEmail());
        h.setHistorique("creation");
        hrepo.save(h);
        return dosrepo.save(dos);
    }
    // update

    @PutMapping("/update/{id}")
    public ResponseEntity<Dossier> updateDos(@PathVariable Long id, @RequestBody Dossier dos){
        Dossier d = dosrepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("le dossier :" + id+ " n'existe pas"));
        d.setImportateur(dos.getImportateur());
        d.setRefbf(dos.getRefbf());
        d.setCin(dos.getCin());
        d.setPassport(dos.getPassport());
        d.setMarque(dos.getMarque());
        d.setModele(dos.getModele());
        d.setNumAvis(dos.getNumAvis());

        Dossier updated = dosrepo.save(d);

        return ResponseEntity.ok(updated);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDemande(@PathVariable Long id){
        Dossier u = dosrepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("le dossier :" + id+ " n'existe pas"));

         Historique h = new Historique();
        h.setDossier(u);
        h.setIntervenant(RegistController.currentUser.getEmail());
        h.setHistorique("creation");

        h.setHistorique("suppression");
        hrepo.save(h);
        dosrepo.delete(u);

        Map<String, Boolean> response = new HashMap<>();
        response.put(id+"deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
