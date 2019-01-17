package di_annotation.pokedex.di.dataaccess;

import di_annotation.pokedex.di.business.domain.Pokemon;

public interface PokemonDao {
    Pokemon findByPokemonId(int id);
}
