package sn.unchk.formateur_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.unchk.formateur_service.dto.FormateurDTO;
import sn.unchk.formateur_service.mapper.FormateurMapper;
import sn.unchk.formateur_service.model.Formateur;
import sn.unchk.formateur_service.service.FormateurService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/formateurs")
@RequiredArgsConstructor
public class FormateurRestController {
    private final FormateurService formateurService;
    @GetMapping
    public List<FormateurDTO> getAllFormateur(){
        return formateurService.getAllFormateur()
                .stream()
                .map(FormateurMapper::toDTO)
                .collect(Collectors.toList());
    }
    @PostMapping
    public Formateur saveFormateur(@RequestBody Formateur f) {
        return formateurService.saveFormateur(f);
    }
    @GetMapping("/{id}")
    public Formateur getFormateurById(@PathVariable Long id) {
        return formateurService.getFormateurById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        formateurService.deleteFormateur(id);
    }
    @PutMapping("{id}")
    public Formateur updated(@PathVariable Long id, @RequestBody Formateur f) {
        return formateurService.updated(id, f);
    }

}
