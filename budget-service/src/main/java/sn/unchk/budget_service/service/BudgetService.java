package sn.unchk.budget_service.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import sn.unchk.budget_service.model.Budget;
import sn.unchk.budget_service.repository.BudgetRepository;

import java.util.List;
import java.util.Optional;
@Service
public class BudgetService {
    private final BudgetRepository repository;

    public BudgetService(BudgetRepository repository) {
        this.repository = repository;
    }

    public Budget save(Budget budget) {
        return repository.save(budget);
    }

    public List<Budget> findAll() {
        return repository.findAll();
    }

    public Optional<Budget> findById(String id) {
        return repository.findById(id);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Budget update(String id, Budget budget) {
        return repository.findById(id).map(b -> {
            b.setProjet(budget.getProjet());
            b.setBudgetPrevu(budget.getBudgetPrevu());
            b.setBudgetRealise(budget.getBudgetRealise());
            b.setAnnee(budget.getAnnee());
            return repository.save(b);
        }).orElse(null);
    }

}
