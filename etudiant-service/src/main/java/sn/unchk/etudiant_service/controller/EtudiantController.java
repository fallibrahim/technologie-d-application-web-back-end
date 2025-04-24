package sn.unchk.etudiant_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.unchk.etudiant_service.dto.EtudiantDTO;

import sn.unchk.etudiant_service.service.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@RequiredArgsConstructor
public class EtudiantController {
    private final EtudiantService etudiantService;

    @GetMapping
    public List<EtudiantDTO> getAll() {
        return etudiantService.getAll();
    }

    @GetMapping("/{id}")
    public EtudiantDTO getById(@PathVariable Long id) {
        return etudiantService.getById(id);
    }


    @PostMapping
    public EtudiantDTO create(@RequestBody EtudiantDTO dto) {
        return etudiantService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        etudiantService.delete(id);
    }

    @GetMapping(params = "ine")
    public EtudiantDTO findByIne(@RequestParam String ine) {
       return etudiantService.findByIne(ine);
    }

    @PutMapping("/{id}")
    public EtudiantDTO update(@PathVariable Long id, @RequestBody EtudiantDTO dto ) {
        return etudiantService.update(id, dto);
    }

}
