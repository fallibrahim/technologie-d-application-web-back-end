package sn.unchk.formateur_service.service;

import sn.unchk.formateur_service.model.Formateur;

import java.util.List;

public interface FormateurService {
    Formateur saveFormateur(Formateur f);
    List<Formateur> getAllFormateur();
    Formateur getFormateurById(Long id);
    void deleteFormateur(Long id);
    Formateur updated(Long id, Formateur f);
}
