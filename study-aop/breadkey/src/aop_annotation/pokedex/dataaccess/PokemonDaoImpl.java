package aop_annotation.pokedex.dataaccess;

import aop_annotation.pokedex.business.domain.Pokemon;
import aop_annotation.pokedex.business.service.PokemonDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PokemonDaoImpl implements PokemonDao {
    private HashMap<Integer, Pokemon> database;
    public PokemonDaoImpl() {
        database = new HashMap<>();
    }

    @Override
    public void addPokemon(Pokemon pokemon) {
        database.put(pokemon.getId(), pokemon);
    }

    @Override
    public Pokemon findPokemon(int id) {
        return database.get(id);
    }
}
