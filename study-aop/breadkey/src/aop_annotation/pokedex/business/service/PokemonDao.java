package aop_annotation.pokedex.business.service;

import aop_annotation.pokedex.business.domain.Pokemon;

public interface PokemonDao {
    void addPokemon(Pokemon pokemon);
    Pokemon findPokemon(int id);
}
