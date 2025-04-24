package sn.unchk.etudiant_service.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudiantDTO {
    private Long id;
    private String ine;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateNaissance;
    private String formation;
    private String promo;
    private int anneeDebut;
    private int anneeSortie;
    private String diplomes;
    private String autresFormations;
}
