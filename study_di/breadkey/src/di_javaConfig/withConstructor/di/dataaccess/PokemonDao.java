package di_javaConfig.withConstructor.di.dataaccess;

import di_javaConfig.withConstructor.di.business.domain.Pokemon;

public interface PokemonDao {
    Pokemon findByPokemonId(int id);
}
