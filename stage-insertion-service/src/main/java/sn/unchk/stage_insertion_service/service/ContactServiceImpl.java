package sn.unchk.stage_insertion_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.unchk.stage_insertion_service.models.Contact;
import sn.unchk.stage_insertion_service.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    private final ContactRepository contactRepository;
    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        return contactRepository.findById(id)
                .map(c -> {
                    c.setNom(contact.getNom());
                    c.setTelephone(contact.getTelephone());
                    c.setEmail(contact.getEmail());
                    c.setFonction(contact.getFonction());
                    return contactRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Contact introuvable"));
    }
}
