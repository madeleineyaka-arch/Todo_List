package com.example.todolist.controller;

import com.example.todolist.dto.TacheDTO;
import com.example.todolist.service.ITacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taches")
@RequiredArgsConstructor
public class TacheController {

    private final ITacheService tacheService;

    @GetMapping
    public List<TacheDTO> obtenirToutesLesTaches() {
        return tacheService.obtenirToutesLesTaches();
    }

    @PostMapping
    public TacheDTO ajouterTache(@RequestBody TacheDTO tacheDTO) {
        return tacheService.ajouterTache(tacheDTO);
    }

    @PutMapping("/{id}")
    public TacheDTO modifierTache(@PathVariable Long id, @RequestBody TacheDTO tacheDTO) {
        return tacheService.modifierTache(id, tacheDTO);
    }

    @DeleteMapping("/{id}")
    public void supprimerTache(@PathVariable Long id) {
        tacheService.supprimerTache(id);
    }

    @PatchMapping("/{id}/terminee")
    public TacheDTO marquerCommeTerminee(@PathVariable Long id) {
        return tacheService.marquerCommeTerminee(id);
    }
}