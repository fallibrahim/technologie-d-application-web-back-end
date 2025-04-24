package sn.unchk.formateur_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sn.unchk.formateur_service.model.Formateur;
import sn.unchk.formateur_service.repository.FormateurRepository;

import java.util.List;
@Service @RequiredArgsConstructor
public class FormateurServiceImpl implements FormateurService{
  private final FormateurRepository formateurRepository;
    @Override
    public Formateur saveFormateur(Formateur f) {
        return formateurRepository.save(f);
    }

    @Override
    public List<Formateur> getAllFormateur() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur getFormateurById(Long id) {
        return formateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Formateur non trouvé"));
    }

    @Override
    public void deleteFormateur(Long id) {
        formateurRepository.deleteById(id);
    }
    @Override
    public Formateur updated(Long id, Formateur updatedFormateurData) {
        Formateur f = formateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        f.setNom(updatedFormateurData.getNom());
        f.setPrenom(updatedFormateurData.getPrenom());
        f.setEmail(updatedFormateurData.getEmail());
        f.setSpecialite(updatedFormateurData.getSpecialite());
        return formateurRepository.save(f);

    }
}
