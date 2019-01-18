package di_javaConfig.withConstructor.di.business.service;

import di_javaConfig.withConstructor.di.business.domain.Pokemon;
import di_javaConfig.withConstructor.di.dataaccess.PokemonDao;

public class BaseStatsCalculateServiceImpl implements BaseStatsCalculateService {
    private PokemonDao pokemonDao;
    public BaseStatsCalculateServiceImpl(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    @Override
    public int calculateTotalBaseStatsById(int id) {
        Pokemon pokemon = pokemonDao.findByPokemonId(id);

        return pokemon.getHp() +
                pokemon.getAttack() + pokemon.getDefense() +
                pokemon.getSpecialAttack() + pokemon.getSpecialDefense() +
                pokemon.getSpeed();
    }
}
