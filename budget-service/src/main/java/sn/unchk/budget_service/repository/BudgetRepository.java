package sn.unchk.budget_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.budget_service.model.Budget;

public interface BudgetRepository extends JpaRepository<Budget, String> {
}
