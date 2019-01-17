package di_annotation.pokedex.di.dataaccess;

import di_annotation.pokedex.di.business.domain.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PokemonDaoImpl implements PokemonDao {
    // 포켓몬 데이터 액세스 오브젝트

    private HashMap<Integer, Pokemon> pokemonDatabase;
    public PokemonDaoImpl() {
        // DI에 대해서 공부할 것이므로 데이터베이스 액세스를 대체한다.
        pokemonDatabase = new HashMap<>();
        pokemonDatabase.put(25, new Pokemon(
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

    public Pokemon findByPokemonId(int id) {
        return pokemonDatabase.get(id);
    }
}
