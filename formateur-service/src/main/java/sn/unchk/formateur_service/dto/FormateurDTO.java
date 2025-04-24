package sn.unchk.formateur_service.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class FormateurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String specialite;
    private String email;
}
