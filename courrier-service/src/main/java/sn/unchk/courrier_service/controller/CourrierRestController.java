package sn.unchk.courrier_service.controller;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import sn.unchk.courrier_service.dto.CourrierDTO;
import sn.unchk.courrier_service.service.CourrierService;

import java.util.List;

@RestController
@RequestMapping("/api/courriers")
public class CourrierRestController {
    private final CourrierService courrierService;

    public CourrierRestController(CourrierService courrierService) {
        this.courrierService = courrierService;
    }

    @PostMapping
    public CourrierDTO create(@RequestBody CourrierDTO dto) {
        return courrierService.createCourrier(dto);
    }

    @GetMapping
    public List<CourrierDTO> getAll() {
        return courrierService.getAllCourriers();
    }

    @GetMapping("/{id}")
    public CourrierDTO getById(@PathVariable String id) {
        return courrierService.getCourrierById(id);
    }

    @PutMapping("/{id}")
    public CourrierDTO update(@PathVariable String id, @RequestBody CourrierDTO dto) {
        return courrierService.updateCourrier(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        courrierService.deleteCourrier(id);
    }
}
