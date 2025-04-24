package sn.unchk.stage_insertion_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.stage_insertion_service.models.BilanStage;

import java.util.List;

public interface BilanStageRepository extends JpaRepository<BilanStage,Long> {
    List<BilanStage> findByEtudiantMatricule(String matricule);
}
