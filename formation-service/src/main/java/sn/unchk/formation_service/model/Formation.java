package sn.unchk.formation_service.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Formation {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String titre;
    private String description;
    private String niveau;
}
