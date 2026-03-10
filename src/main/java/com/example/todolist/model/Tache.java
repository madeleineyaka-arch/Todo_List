package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private Statut statut = Statut.EN_COURS;
}