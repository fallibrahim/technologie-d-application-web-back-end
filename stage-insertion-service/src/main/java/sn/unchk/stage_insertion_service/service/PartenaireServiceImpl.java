package sn.unchk.stage_insertion_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.unchk.stage_insertion_service.models.Partenaire;
import sn.unchk.stage_insertion_service.repository.PartenaireRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartenaireServiceImpl implements PartenaireService {

    private final PartenaireRepository repository;

    @Override
    public Partenaire ajouterPartenaire(Partenaire partenaire) {
        return repository.save(partenaire);
    }

    @Override
    public List<Partenaire> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Partenaire> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Partenaire> getByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public void supprimer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Partenaire modifier(Long id, Partenaire partenaire) {
        return repository.findById(id).map(p -> {
            p.setNom(partenaire.getNom());
            p.setType(partenaire.getType());
            p.setEmail(partenaire.getEmail());
            p.setTelephone(partenaire.getTelephone());
            p.setAdresse(partenaire.getAdresse());
            p.setDomaine(partenaire.getDomaine());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Partenaire non trouvé"));
    }
}
