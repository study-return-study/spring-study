package di_bean.pokedex.di.business.service;

import di_bean.pokedex.di.business.domain.Pokemon;

public interface PokedexService {
    Pokemon findByPokemonId(int id);
    int calculateTotalBaseStats(Pokemon pokemon);
}
