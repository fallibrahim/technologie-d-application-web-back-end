package sn.unchk.etudiant_service.service;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sn.unchk.etudiant_service.dto.EtudiantDTO;
import sn.unchk.etudiant_service.model.Etudiant;
import sn.unchk.etudiant_service.repository.EtudiantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService{


    private final EtudiantRepository etudiantRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<EtudiantDTO> getAll() {
        return etudiantRepository.findAll().stream()
                .map(e -> modelMapper.map(e, EtudiantDTO.class))
                .collect(Collectors.toList());
    }



    @Override
    public EtudiantDTO getById(Long id) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non trouvé avec l'id : " + id));
        return modelMapper.map(etudiant, EtudiantDTO.class);
    }

    @Override
    public EtudiantDTO findByIne(String ine) {
        EtudiantDTO etudiant = etudiantRepository.findByIne(ine)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "INE non trouvé : " + ine));
        return modelMapper.map(etudiant, EtudiantDTO.class);
    }


    @Override
    public EtudiantDTO create(EtudiantDTO dto) {
        Etudiant etudiant = modelMapper.map(dto, Etudiant.class);
        Etudiant saved = etudiantRepository.save(etudiant);
        return modelMapper.map(saved, EtudiantDTO.class);
    }

    @Override
    public EtudiantDTO update(Long id, EtudiantDTO dto) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        etudiant.setIne(dto.getIne());
        etudiant.setNom(dto.getNom());
        etudiant.setPrenom(dto.getPrenom());
        etudiant.setEmail(dto.getEmail());
        etudiant.setDateNaissance(dto.getDateNaissance());
        etudiant.setFormation(dto.getFormation());
        etudiant.setPromo(dto.getPromo());
        etudiant.setAnneeDebut(dto.getAnneeDebut());
        etudiant.setAnneeSortie(dto.getAnneeSortie());
        etudiant.setDiplomes(dto.getDiplomes());
        etudiant.setAutresFormations(dto.getAutresFormations());

        Etudiant updated = etudiantRepository.save(etudiant);
        return modelMapper.map(updated, EtudiantDTO.class);
    }



    @Override
    public void delete(Long id) {
        if (etudiantRepository.existsById(id)) {
            etudiantRepository.deleteByIdWithoutLoading(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non trouvé avec l'id : " + id);
        }
    }


}
