package com.example.todolist.dto;

import lombok.Data;

@Data
public class TacheDTO {
    private Long id;
    private String titre;
    private String description;
    private String statut;
}