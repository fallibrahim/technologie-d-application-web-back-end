package sn.unchk.stage_insertion_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class BilanInsertion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEtudiant;

    private String formation;

    private String partenaire;

    private String secteur;

    private LocalDate dateInsertion;

    private String statut;

    private int annee;
}
