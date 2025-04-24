package sn.unchk.stage_insertion_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.unchk.stage_insertion_service.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
