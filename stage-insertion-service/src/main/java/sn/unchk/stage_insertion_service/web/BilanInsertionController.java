package sn.unchk.stage_insertion_service.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.unchk.stage_insertion_service.models.BilanInsertion;
import sn.unchk.stage_insertion_service.service.BilanInsertionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bilan-insertion")
@RequiredArgsConstructor
public class BilanInsertionController {

    private final BilanInsertionService service;

    @PostMapping
    public ResponseEntity<BilanInsertion> enregistrer(@RequestBody BilanInsertion bilan) {
        return new ResponseEntity<>(service.enregistrer(bilan), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BilanInsertion>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/statistiques/secteur/{annee}")
    public ResponseEntity<Map<String, Long>> getStatsParSecteur(@PathVariable int annee) {
        return ResponseEntity.ok(service.statistiquesParSecteur(annee));
    }

    @GetMapping("/statistiques/statut")
    public ResponseEntity<Map<String, Long>> getStatsParStatut() {
        return ResponseEntity.ok(service.statistiquesParStatut());
    }
}
