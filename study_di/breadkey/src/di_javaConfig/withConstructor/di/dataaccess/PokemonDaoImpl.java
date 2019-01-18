package di_javaConfig.withConstructor.di.dataaccess;

import di_javaConfig.withConstructor.di.business.domain.Pokemon;

import java.util.HashMap;

public class PokemonDaoImpl implements PokemonDao {
    private HashMap<Integer, Pokemon> database;

    public PokemonDaoImpl() {
        System.out.println("PokemonDao 생성됨");

        database = new HashMap<>();
        database.put(25, new Pokemon(
                25,
                "피카츄",
                35,
                55,
                40,
                50,
                50,
                90
        ));
    }

    @Override
    public Pokemon findByPokemonId(int id) {
        return database.get(id);
    }
}
