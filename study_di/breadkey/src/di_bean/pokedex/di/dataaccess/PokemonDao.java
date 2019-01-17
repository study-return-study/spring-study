package di_bean.pokedex.di.dataaccess;

import di_bean.pokedex.di.business.domain.Pokemon;

public interface PokemonDao {
    Pokemon findByPokemonId(int id);
}
