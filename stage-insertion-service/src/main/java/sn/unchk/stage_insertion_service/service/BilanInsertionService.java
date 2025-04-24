package sn.unchk.stage_insertion_service.service;

import sn.unchk.stage_insertion_service.models.BilanInsertion;

import java.util.List;
import java.util.Map;

public interface BilanInsertionService {
    BilanInsertion enregistrer(BilanInsertion bilan);
    List<BilanInsertion> getAll();
    Map<String, Long> statistiquesParSecteur(int annee);
    Map<String, Long> statistiquesParStatut();
}
