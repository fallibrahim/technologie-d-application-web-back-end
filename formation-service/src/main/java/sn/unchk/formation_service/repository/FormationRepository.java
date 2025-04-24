package sn.unchk.formation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.formation_service.model.Formation;

public interface FormationRepository extends JpaRepository<Formation, String> {
}
