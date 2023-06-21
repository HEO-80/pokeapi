package com.example.demo.controller;

import com.example.demo.model.Pokemon;
import com.example.demo.model.PokemonDetailsResponse;
import com.example.demo.model.PokemonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/api")
public class PokeController {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public PokeController(@Qualifier("webClientBuilder") WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons() {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/";

        PokemonResponse response = webClientBuilder.build()
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(PokemonResponse.class)
                .block();

        if (response != null && response.getResults() != null) {
            List<Pokemon> pokemonList = response.getResults();
            return ResponseEntity.ok().body(pokemonList);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<PokemonDetailsResponse> getPokemonDetails(@PathVariable("id") String id) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + id;

        PokemonDetailsResponse pokemonDetails = webClientBuilder.build()
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(PokemonDetailsResponse.class)
                .block();

        if (pokemonDetails != null) {
            pokemonDetails.setId(Integer.parseInt(id)); // Establecer el ID manualmente
            return ResponseEntity.ok().body(pokemonDetails);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
