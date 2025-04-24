package sn.unchk.stage_insertion_service.service;

import sn.unchk.stage_insertion_service.models.Partenaire;

import java.util.List;
import java.util.Optional;

public interface PartenaireService {
    Partenaire ajouterPartenaire(Partenaire partenaire);
    List<Partenaire> getAll();
    Optional<Partenaire> getById(Long id);
    List<Partenaire> getByType(String type);
    void supprimer(Long id);
    Partenaire modifier(Long id, Partenaire partenaire);
}
