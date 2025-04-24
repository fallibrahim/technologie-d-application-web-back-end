package sn.unchk.courrier_service.mapper;

import sn.unchk.courrier_service.dto.CourrierDTO;
import sn.unchk.courrier_service.model.Courrier;

public class CourrierMapper {
    public static CourrierDTO toDTO(Courrier courrier) {
        CourrierDTO dto = new CourrierDTO();
        dto.setId(courrier.getId());
        dto.setType(courrier.getType());
        dto.setObjet(courrier.getObjet());
        dto.setExpediteur(courrier.getExpediteur());
        dto.setDestinataire(courrier.getDestinataire());
        dto.setDateReception(courrier.getDateReception());
        dto.setStatut(courrier.getStatut());
        return dto;
    }


    public static Courrier toEntity(CourrierDTO dto) {
        Courrier courrier = new Courrier();
        courrier.setId(dto.getId());
        courrier.setType(dto.getType());
        courrier.setObjet(dto.getObjet());
        courrier.setExpediteur(dto.getExpediteur());
        courrier.setDestinataire(dto.getDestinataire());
        courrier.setDateReception(dto.getDateReception());
        courrier.setStatut(dto.getStatut());
        return courrier;
    }
}
