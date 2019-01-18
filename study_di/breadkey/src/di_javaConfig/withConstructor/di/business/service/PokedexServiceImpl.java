package di_javaConfig.withConstructor.di.business.service;

import di_javaConfig.withConstructor.di.business.domain.Pokemon;
import di_javaConfig.withConstructor.di.dataaccess.PokemonDao;

public class PokedexServiceImpl implements PokedexService {
    private PokemonDao pokemonDao;
    public PokedexServiceImpl(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    @Override
    public Pokemon findByPokemonId(int id) {
        return pokemonDao.findByPokemonId(id);
    }
}
