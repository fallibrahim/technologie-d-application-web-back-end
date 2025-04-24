package sn.unchk.stage_insertion_service.service;

import sn.unchk.stage_insertion_service.models.BilanStage;

import java.util.List;
import java.util.Optional;

public interface BilanStageService {
    BilanStage createBilan(BilanStage bilan);
    List<BilanStage> getAllBilans();
    Optional<BilanStage> getBilanById(Long id);
    List<BilanStage> getBilansByEtudiant(String matricule);
    void deleteBilan(Long id);
    BilanStage updateBilan(Long id, BilanStage bilan);
}
