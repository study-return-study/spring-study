package di_bean.pokedex.di.business.service;

import di_bean.pokedex.di.dataaccess.PokemonDao;
import di_bean.pokedex.di.business.domain.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class PokedexServiceImpl implements PokedexService {
    // 비즈니스 로직을 실현하는 클래스
    private PokemonDao pokemonDao;

    // 인젝션을 위한 Setter 메서드
    public void setPokemonDao(PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonDao.addPokemon(pokemon);
    }

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

    @Override
    public List<Pokemon> findAllPokemons() {
        return pokemonDao.findAllPokemons();
    }
}
