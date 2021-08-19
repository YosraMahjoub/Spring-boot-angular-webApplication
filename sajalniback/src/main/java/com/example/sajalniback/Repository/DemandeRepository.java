package com.example.sajalniback.Repository;

import com.example.sajalniback.model.Demande;
import com.example.sajalniback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {


    List<Demande> findByUser(User currentUser);

    List<Demande> findByRefbfAndStatut(String refbf, String en_cours);

    List<Demande> findByStatut(String en_cours);
}
