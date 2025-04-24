package sn.unchk.formation_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.unchk.formation_service.model.Formation;
import sn.unchk.formation_service.repository.FormationRepository;

import java.util.List;



@RestController
@RequestMapping("/api/formations")
@RequiredArgsConstructor
public class FormationController {
    private final FormationRepository repository;

    @GetMapping
    public List<Formation> getAll() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Formation getById(@PathVariable String id) {
        return repository.findById(id).get();
    }
    @PostMapping
    public Formation create(@RequestBody Formation formation) {
        return repository.save(formation);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Formation> update(@PathVariable String id, @RequestBody Formation formation) {
        return repository.findById(id)
                .map(f -> {
                    f.setTitre(formation.getTitre());
                    f.setDescription(formation.getDescription());
                    f.setNiveau(formation.getNiveau());
                    return ResponseEntity.ok(repository.save(f));
                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}
