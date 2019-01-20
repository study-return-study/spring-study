package di_bean.pokedex.di.business.service;

import di_bean.pokedex.di.business.domain.Pokemon;

public interface PokedexService {
    void addPokemon(Pokemon pokemon);
    Pokemon findByPokemonId(int id);
    int calculateTotalBaseStats(Pokemon pokemon);
}
