package sn.unchk.stage_insertion_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.unchk.stage_insertion_service.models.BilanInsertion;
import sn.unchk.stage_insertion_service.repository.BilanInsertionRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BilanInsertionServiceImpl implements BilanInsertionService{


    private final BilanInsertionRepository repository;

    @Override
    public BilanInsertion enregistrer(BilanInsertion bilan) {
        return repository.save(bilan);
    }

    @Override
    public List<BilanInsertion> getAll() {
        return repository.findAll();
    }

    @Override
    public Map<String, Long> statistiquesParSecteur(int annee) {
        List<BilanInsertion> bilans = repository.findByAnnee(annee);
        return bilans.stream()
                .collect(Collectors.groupingBy(BilanInsertion::getSecteur, Collectors.counting()));
    }

    @Override
    public Map<String, Long> statistiquesParStatut() {
        List<BilanInsertion> bilans = repository.findAll();
        return bilans.stream()
                .collect(Collectors.groupingBy(BilanInsertion::getStatut, Collectors.counting()));
    }
}
