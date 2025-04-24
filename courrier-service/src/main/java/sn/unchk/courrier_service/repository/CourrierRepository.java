package sn.unchk.courrier_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.courrier_service.model.Courrier;

public interface CourrierRepository extends JpaRepository<Courrier,String> {

}
