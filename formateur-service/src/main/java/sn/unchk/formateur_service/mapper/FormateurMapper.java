package sn.unchk.formateur_service.mapper;

import sn.unchk.formateur_service.dto.FormateurDTO;
import sn.unchk.formateur_service.model.Formateur;

public class FormateurMapper {
    public static FormateurDTO toDTO(Formateur f) {
        FormateurDTO dto = new FormateurDTO();
        dto.setId(f.getId());
        dto.setNom(f.getNom());
        dto.setPrenom(f.getPrenom());
        dto.setSpecialite(f.getSpecialite());
        dto.setEmail(f.getEmail());
        return dto;
    }
    public static Formateur toEntity(FormateurDTO dto) {
        Formateur f = new Formateur();
        f.setId(dto.getId());
        f.setNom(dto.getNom());
        f.setPrenom(dto.getPrenom());
        f.setEmail(dto.getEmail());
        f.setSpecialite(dto.getSpecialite());
        return f;
    }
}
