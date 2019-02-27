package di_bean.pokedex.di.business.service;

import di_bean.pokedex.di.business.domain.Pokemon;

import java.util.List;

public interface PokedexService {
    void addPokemon(Pokemon pokemon);
    Pokemon findByPokemonId(int id);
    int calculateTotalBaseStats(Pokemon pokemon);
    List<Pokemon> findAllPokemons();
    void addPokemons(List<Pokemon> pokemons);
}
