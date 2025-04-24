package sn.unchk.formateur_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.formateur_service.model.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
