package sn.unchk.stage_insertion_service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.unchk.stage_insertion_service.models.BilanStage;
import sn.unchk.stage_insertion_service.service.BilanStageService;

import java.util.List;

@RestController
@RequestMapping("/api/bilans")
@RequiredArgsConstructor
public class BilanStageController {
    private final BilanStageService bilanStageService;

    @PostMapping
    public ResponseEntity<BilanStage> create(@RequestBody BilanStage bilan) {
        return new ResponseEntity<>(bilanStageService.createBilan(bilan), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BilanStage>> getAll() {
        return ResponseEntity.ok(bilanStageService.getAllBilans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BilanStage> getById(@PathVariable Long id) {
        return bilanStageService.getBilanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/etudiant/{matricule}")
    public ResponseEntity<List<BilanStage>> getByEtudiant(@PathVariable String matricule) {
        return ResponseEntity.ok(bilanStageService.getBilansByEtudiant(matricule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BilanStage> update(@PathVariable Long id, @RequestBody BilanStage bilan) {
        return ResponseEntity.ok(bilanStageService.updateBilan(id, bilan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bilanStageService.deleteBilan(id);
        return ResponseEntity.noContent().build();
    }
}
