package com.example.sajalniback.Controller;

import com.example.sajalniback.Repository.DemandeRepository;
import com.example.sajalniback.Repository.DossierRepository;
import com.example.sajalniback.Repository.HistoriqueRepository;
import com.example.sajalniback.Request.PointageRequest;
import com.example.sajalniback.exception.UserNotFoundException;
import com.example.sajalniback.model.Demande;
import com.example.sajalniback.model.Dossier;
import com.example.sajalniback.model.Historique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pointage")
public class PointageController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private HistoriqueRepository hrepo;

    @Autowired
    private DossierRepository dosrepo;

    @Autowired
    private DemandeRepository demrepo;

    @RequestMapping("/alldem")
    public List<Demande> ta() {

        return demrepo.findByStatut("en_cours");
    }

    @RequestMapping("/alldos")
    public List<Dossier> al() {

        return dosrepo.findByStatut("en_cours");
    }


    @PostMapping("/accepter")
    public ResponseEntity<Dossier> accepter(@RequestBody PointageRequest request)  throws UserNotFoundException {
        Dossier dos = dosrepo.findById(request.getIddos())
                .orElseThrow(() -> new UserNotFoundException("le dossier avec l'id: " + request.getIddos() +" n'existe pas"));

       dos.setStatut("accepte");
        dos.setIdDemande(request.getIddemacc());
        Historique h = new Historique();
        h.setDossier(dos);
        h.setIntervenant(RegistController.currentUser.getEmail());
        h.setHistorique("acceptation");
        hrepo.save(h);
       dosrepo.save(dos);
        Demande demacc = demrepo.findById(request.getIddemacc())
                .orElseThrow(() -> new UserNotFoundException("la demande :" + request.getIddemacc() + " n'existe pas"));
        demacc.setStatut("accepte");
        demacc.setIdDossier(request.getIddos());
        demrepo.save(demacc);
       List<Demande> dems = demrepo.findByRefbfAndStatut(request.getRefbf(),"en_cours");
        dems.forEach(demande -> {
            demande.setStatut("refuse");
            demrepo.save(demande);
        });
        return ResponseEntity.ok(dos);
    }

    @PostMapping("/refuser")
    public ResponseEntity<Demande> refuser(@RequestBody PointageRequest request)  throws UserNotFoundException {
        log.info("//////// dmref//////  {} ", request.getIddemref());
        Demande demref = demrepo.findById(request.getIddemref())
                .orElseThrow(() -> new UserNotFoundException("la demande :" + request.getIddemref() + " n'existe pas"));
        demref.setStatut("refusee");
        demrepo.save(demref);
        List<Demande> dems = demrepo.findByRefbfAndStatut(request.getRefbf(),"en_cours");
        log.info("//////// dms//////  {} ", dems.size());
        if (dems.size() == 0) {
            log.info("//////// dms//////  {} ", dems);
            Dossier dos = dosrepo.findById(request.getIddos())
                    .orElseThrow(() -> new UserNotFoundException("le dossier avec l'id: " + request.getIddos() +" n'existe pas"));

            dos.setStatut("refusee");
            dos.setIdDemande(request.getIddemref());
            Historique h = new Historique();
            h.setDossier(dos);
            h.setIntervenant(RegistController.currentUser.getEmail());
            h.setHistorique("refus");
            hrepo.save(h);
            dosrepo.save(dos);
        }
        return ResponseEntity.ok(demref);
    }


}
