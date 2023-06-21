package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonResponse {
    private List<Pokemon> results;
}