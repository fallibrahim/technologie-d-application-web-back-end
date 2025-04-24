package sn.unchk.stage_insertion_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.stage_insertion_service.models.BilanInsertion;

import java.util.List;

public interface BilanInsertionRepository extends JpaRepository<BilanInsertion, Long> {
    List<BilanInsertion> findByAnnee(int annee);

    long countByAnnee(int annee);

    long countBySecteurAndAnnee(String secteur, int annee);

    long countByStatut(String statut);
}
