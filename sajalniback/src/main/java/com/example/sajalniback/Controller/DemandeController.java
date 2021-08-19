package com.example.sajalniback.Controller;

import com.example.sajalniback.Repository.DemandeRepository;
import com.example.sajalniback.Repository.UserRepository;
import com.example.sajalniback.Request.UserRequest;
import com.example.sajalniback.Security.UserDetailsImpl;
import com.example.sajalniback.exception.UserNotFoundException;
import com.example.sajalniback.model.Demande;
import com.example.sajalniback.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/demande")
public class DemandeController {
    private final Logger log = LoggerFactory.getLogger(DemandeController.class);
    @Autowired
    private DemandeRepository demrepo;

    @Autowired
    private UserRepository userRepo;


    //list
    @RequestMapping("/all")
    public List<Demande> getAllDm() {
        return demrepo.findAll();
    }

    //CURRENTUSER list
    @RequestMapping("/myall")
    public List<Demande> getAllmyDm() {

        return demrepo.findByUser(RegistController.currentUser);
    }



    //detail
    @GetMapping("/find/{id}")
    public ResponseEntity<Demande> getdemandeById(@PathVariable(value = "id") Long id)
            throws UserNotFoundException {
        Demande d = demrepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("la demande :" + id+ " n'existe pas"));
        return ResponseEntity.ok().body(d);
    }


    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDemande(@PathVariable Long id){
        Demande u = demrepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("la demande :" + id+ " n'existe pas"));
       demrepo.delete(u);
        Map<String, Boolean> response = new HashMap<>();
        response.put(id+"deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //ajout
    @PostMapping("/add")
    public Demande createDM(@RequestBody Demande demande) {
       // Demande d = new Demande(demande.getCin(), demande.getPassport(), demande.getMarque(), demande.getModele(), demande.getNumSerie(), demande.getImei1(), demande.getImei2(), demande.getImei3()) {

       demande.setStatut("en_cours");

       demande.setUser(RegistController.currentUser);
        return demrepo.save(demande);
    }

    // update

    @PutMapping("/update/{id}")
    public ResponseEntity<Demande> updateDM(@PathVariable Long id, @RequestBody Demande demandeinfo){
        Demande d = demrepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("la demande :" + id+ " n'existe pas"));
        d.setCin(demandeinfo.getCin());
        d.setPassport(demandeinfo.getPassport());
        d.setMarque(demandeinfo.getMarque());
        d.setModele(demandeinfo.getModele());
        d.setImei1(demandeinfo.getImei1());
        d.setImei2(demandeinfo.getImei2());
        d.setImei3(demandeinfo.getImei3());
        d.setNumSerie(demandeinfo.getNumSerie());

        Demande updated = demrepo.save(d);

        return ResponseEntity.ok(updated);
    }

}
