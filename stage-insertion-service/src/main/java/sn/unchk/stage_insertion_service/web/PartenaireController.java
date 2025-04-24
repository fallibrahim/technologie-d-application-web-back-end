package sn.unchk.stage_insertion_service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.unchk.stage_insertion_service.models.Partenaire;
import sn.unchk.stage_insertion_service.service.PartenaireService;

import java.util.List;

@RestController
@RequestMapping("/api/partenaires")
@RequiredArgsConstructor
public class PartenaireController {
    private final PartenaireService service;

    @PostMapping
    public ResponseEntity<Partenaire> create(@RequestBody Partenaire partenaire) {
        return new ResponseEntity<>(service.ajouterPartenaire(partenaire), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Partenaire>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partenaire> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Partenaire>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(service.getByType(type));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partenaire> update(@PathVariable Long id, @RequestBody Partenaire partenaire) {
        return ResponseEntity.ok(service.modifier(id, partenaire));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
