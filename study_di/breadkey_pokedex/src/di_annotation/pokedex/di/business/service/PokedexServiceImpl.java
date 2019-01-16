package di_annotation.pokedex.di.business.service;

import di_annotation.pokedex.di.business.domain.Pokemon;
import di_annotation.pokedex.di.dataaccess.PokemonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokedexServiceImpl implements PokedexService {
    // 비즈니스 로직을 실현하는 클래스
    @Autowired
    private PokemonDao pokemonDao;

    public Pokemon findByPokemonId(int id) {
        return pokemonDao.findByPokemonId(id);
    }

    public int calculateTotalBaseStats(Pokemon pokemon) {
        return pokemon.getHp() +
                pokemon.getAttack() +
                pokemon.getDefense() +
                pokemon.getSpecialAttack() +
                pokemon.getSpecialDefense() +
                pokemon.getSpeed();
    }
}
