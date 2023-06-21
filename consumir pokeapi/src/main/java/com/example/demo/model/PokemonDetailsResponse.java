package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDetailsResponse {

    private List<PokemonDetails.Ability> abilities;
    private int height;
    private int weight;

    public void setId(int i) {

    }

    // Getters y setters
}

