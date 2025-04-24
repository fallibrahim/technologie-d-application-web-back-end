package sn.unchk.etudiant_service.service;

import sn.unchk.etudiant_service.dto.EtudiantDTO;
import sn.unchk.etudiant_service.model.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<EtudiantDTO> getAll();
    EtudiantDTO create(EtudiantDTO dto);
    void delete(Long id);
    EtudiantDTO update(Long id, EtudiantDTO dto);
    EtudiantDTO getById(Long id);
    EtudiantDTO findByIne(String ine);
}
