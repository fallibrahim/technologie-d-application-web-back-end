package sn.unchk.courrier_service.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import sn.unchk.courrier_service.dto.CourrierDTO;
import sn.unchk.courrier_service.mapper.CourrierMapper;
import sn.unchk.courrier_service.model.Courrier;
import sn.unchk.courrier_service.repository.CourrierRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourrierService {
    private final CourrierRepository courrierRepository;

    public CourrierService(CourrierRepository courrierRepository) {
        this.courrierRepository = courrierRepository;
    }

    public CourrierDTO createCourrier(CourrierDTO dto) {
        Courrier courrier = CourrierMapper.toEntity(dto);
        Courrier saved = courrierRepository.save(courrier);
        return CourrierMapper.toDTO(saved);
    }

    public List<CourrierDTO> getAllCourriers() {
        return courrierRepository.findAll()
                .stream()
                .map(CourrierMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourrierDTO getCourrierById(String id) {
        return courrierRepository.findById(id)
                .map(CourrierMapper::toDTO)
                .orElse(null);
    }

    public CourrierDTO updateCourrier(String id, CourrierDTO dto) {
        Courrier existing = courrierRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setType(dto.getType());
        existing.setObjet(dto.getObjet());
        existing.setExpediteur(dto.getExpediteur());
        existing.setDestinataire(dto.getDestinataire());
        existing.setDateReception(dto.getDateReception());
        existing.setStatut(dto.getStatut());

        return CourrierMapper.toDTO(courrierRepository.save(existing));
    }

    public void deleteCourrier(String id) {
        courrierRepository.deleteById(id);
    }
}
