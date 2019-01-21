package aop_annotation.pokedex.business.service;

import aop_annotation.pokedex.business.domain.Pokemon;

public interface PokedexService {
    void addPokemon(Pokemon pokemon);
    Pokemon findPokemonById(int id);
}
