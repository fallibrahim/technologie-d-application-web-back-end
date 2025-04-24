package sn.unchk.stage_insertion_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatistiqueInsertion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int annee;
    private int nombreInserts;
    private int nombreDiplomes;
}
