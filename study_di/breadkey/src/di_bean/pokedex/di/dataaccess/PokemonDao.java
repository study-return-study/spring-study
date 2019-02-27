package di_bean.pokedex.di.dataaccess;

import di_bean.pokedex.di.business.domain.Pokemon;

import java.util.List;

public interface PokemonDao {
    void addPokemon(Pokemon pokemon);
    Pokemon findByPokemonId(int id);
    List<Pokemon> findAllPokemons();
}
