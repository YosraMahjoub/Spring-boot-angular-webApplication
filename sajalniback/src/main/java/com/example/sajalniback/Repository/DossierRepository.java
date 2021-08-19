package com.example.sajalniback.Repository;

import com.example.sajalniback.model.Dossier;
import com.example.sajalniback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long> {
    List<Dossier> findByUser(User currentUser);

    List<Dossier> findByStatut(String en_cours);
}
