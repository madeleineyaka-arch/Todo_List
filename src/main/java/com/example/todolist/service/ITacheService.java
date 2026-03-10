package com.example.todolist.service;

import com.example.todolist.dto.TacheDTO;
import java.util.List;

public interface ITacheService {
    List<TacheDTO> obtenirToutesLesTaches();
    TacheDTO ajouterTache(TacheDTO tacheDTO);
    TacheDTO modifierTache(Long id, TacheDTO tacheDTO);
    void supprimerTache(Long id);
    TacheDTO marquerCommeTerminee(Long id);
}