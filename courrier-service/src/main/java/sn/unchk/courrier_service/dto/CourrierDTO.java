package sn.unchk.courrier_service.dto;

import lombok.*;

import java.time.LocalDate;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class CourrierDTO {
    private String id;
    private String type;
    private String objet;
    private String expediteur;
    private String destinataire;
    private LocalDate dateReception;
    private String statut;
}
