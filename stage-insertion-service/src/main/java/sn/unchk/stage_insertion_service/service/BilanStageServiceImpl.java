package sn.unchk.stage_insertion_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.unchk.stage_insertion_service.models.BilanStage;
import sn.unchk.stage_insertion_service.repository.BilanStageRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BilanStageServiceImpl implements BilanStageService{
    private final BilanStageRepository repository;

    @Override
    public BilanStage createBilan(BilanStage bilan) {
        return repository.save(bilan);
    }

    @Override
    public List<BilanStage> getAllBilans() {
        return repository.findAll();
    }

    @Override
    public Optional<BilanStage> getBilanById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<BilanStage> getBilansByEtudiant(String matricule) {
        return repository.findByEtudiantMatricule(matricule);
    }

    @Override
    public void deleteBilan(Long id) {
        repository.deleteById(id);
    }

    @Override
    public BilanStage updateBilan(Long id, BilanStage bilan) {
        return repository.findById(id)
                .map(b -> {
                    b.setTitre(bilan.getTitre());
                    b.setDescription(bilan.getDescription());
                    b.setDateDepot(bilan.getDateDepot());
                    b.setEtudiantMatricule(bilan.getEtudiantMatricule());
                    return repository.save(b);
                }).orElseThrow(() -> new RuntimeException("Bilan introuvable"));
    }
}
