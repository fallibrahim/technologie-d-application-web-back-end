package sn.unchk.courrier_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class Courrier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String type;
    private String objet;
    private String expediteur;
    private String destinataire;
    private LocalDate dateReception;
    private String statut;
    private String fichier;

    private String note;
}
