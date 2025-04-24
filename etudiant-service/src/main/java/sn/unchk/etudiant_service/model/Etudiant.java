package sn.unchk.etudiant_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotBlank(message = "L'INE est obligatoire")
    private String ine;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le prenom est obligatoire")
    private String prenom;
    @NotBlank(message = "L'email est obligatoire")
    private String email;
    @NotNull(message = "La date de naissance est obligatoire")
    private LocalDate dateNaissance;
    @NotBlank(message = "La formation est obligatoire")
    private String formation;
    @NotBlank(message = "Le promo est obligatoire")
    private String promo;
    @Min(value = 1900, message = "Année invalide")
    private int anneeDebut;
    @NotNull(message = "L'annee de sorite est obligatoire")
    private int anneeSortie;
    @NotBlank(message = "Le diplome est obligatoire")
    private String diplomes;
    private String autresFormations;
}
