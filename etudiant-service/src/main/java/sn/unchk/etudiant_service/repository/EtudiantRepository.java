package sn.unchk.etudiant_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import sn.unchk.etudiant_service.dto.EtudiantDTO;
import sn.unchk.etudiant_service.model.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<EtudiantDTO> findByIne(String ine);
    @Modifying
    @Transactional
    @Query("DELETE FROM Etudiant e WHERE e.id = :id")
    void deleteByIdWithoutLoading(Long id);
}
