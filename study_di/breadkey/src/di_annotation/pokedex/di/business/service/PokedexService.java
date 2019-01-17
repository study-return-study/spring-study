package di_annotation.pokedex.di.business.service;

import di_annotation.pokedex.di.business.domain.Pokemon;

public interface PokedexService {
    Pokemon findByPokemonId(int id);
    int calculateTotalBaseStats(Pokemon pokemon);
}
