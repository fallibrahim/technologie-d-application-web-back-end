package sn.unchk.budget_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.unchk.budget_service.model.Budget;
import sn.unchk.budget_service.service.BudgetService;

import java.util.List;
@RestController
@RequestMapping("/api/budgets")
@CrossOrigin(origins = "*")
public class BudgetRestController {
    private final BudgetService service;

    public BudgetRestController(BudgetService service) {
        this.service = service;
    }

    @PostMapping
    public Budget create(@RequestBody Budget budget) {
        return service.save(budget);
    }

    @GetMapping
    public List<Budget> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Budget> getById(@PathVariable String id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> update(@PathVariable String id, @RequestBody Budget budget) {
        Budget updated = service.update(id, budget);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
