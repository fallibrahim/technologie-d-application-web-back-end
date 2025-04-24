package sn.unchk.stage_insertion_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.stage_insertion_service.models.Partenaire;

import java.util.List;

public interface PartenaireRepository extends JpaRepository<Partenaire, Long> {
    List<Partenaire> findByType(String type);
}
