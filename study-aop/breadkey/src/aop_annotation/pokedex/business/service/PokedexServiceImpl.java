package aop_annotation.pokedex.business.service;

import aop_annotation.pokedex.business.domain.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokedexServiceImpl implements PokedexService {
    @Autowired
    PokemonDao pokemonDao;

    @Override
    public void addPokemon(Pokemon pokemon) {
        pokemonDao.addPokemon(pokemon);
    }

    @Override
    public Pokemon findPokemonById(int id) {
        return pokemonDao.findPokemon(id);
    }
}
