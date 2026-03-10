package com.example.todolist.service;

import com.example.todolist.dto.TacheDTO;
import com.example.todolist.model.Statut;
import com.example.todolist.model.Tache;
import com.example.todolist.repository.ITacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TacheServiceImpl implements ITacheService {

    private final ITacheRepository tacheRepository;

    @Override
    public List<TacheDTO> obtenirToutesLesTaches() {
        return tacheRepository.findAll()
                .stream()
                .map(this::convertirEnDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TacheDTO ajouterTache(TacheDTO tacheDTO) {
        Tache tache = new Tache();
        tache.setTitre(tacheDTO.getTitre());
        tache.setDescription(tacheDTO.getDescription());
        tacheRepository.save(tache);
        return convertirEnDTO(tache);
    }

    @Override
    public TacheDTO modifierTache(Long id, TacheDTO tacheDTO) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
        tache.setTitre(tacheDTO.getTitre());
        tache.setDescription(tacheDTO.getDescription());
        tache.setStatut(Statut.valueOf(tacheDTO.getStatut()));
        tacheRepository.save(tache);
        return convertirEnDTO(tache);
    }

    @Override
    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);
    }

    @Override
    public TacheDTO marquerCommeTerminee(Long id) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
        tache.setStatut(Statut.TERMINE);
        tacheRepository.save(tache);
        return convertirEnDTO(tache);
    }

    private TacheDTO convertirEnDTO(Tache tache) {
        TacheDTO dto = new TacheDTO();
        dto.setId(tache.getId());
        dto.setTitre(tache.getTitre());
        dto.setDescription(tache.getDescription());
        dto.setStatut(tache.getStatut().name());
        return dto;
    }
}