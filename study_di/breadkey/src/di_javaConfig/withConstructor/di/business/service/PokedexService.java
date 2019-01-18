package di_javaConfig.withConstructor.di.business.service;

import di_javaConfig.withConstructor.di.business.domain.Pokemon;

public interface PokedexService {
    Pokemon findByPokemonId(int id);
}
