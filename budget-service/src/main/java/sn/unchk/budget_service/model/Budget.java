package sn.unchk.budget_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String projet;
    private Double budgetPrevu;
    private Double budgetRealise;
    private int annee;
}
