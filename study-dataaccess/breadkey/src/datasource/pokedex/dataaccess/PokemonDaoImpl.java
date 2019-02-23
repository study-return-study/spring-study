package datasource.pokedex.dataaccess;

import di_bean.pokedex.di.business.domain.Pokemon;
import di_bean.pokedex.di.dataaccess.PokemonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PokemonDaoImpl implements PokemonDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void addPokemon(Pokemon pokemon) {

    }

    @Override
    public Pokemon findByPokemonId(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM POKEMON WHERE POKEMON_ID=?", new PokemonMapper(), id);
    }
}

class PokemonMapper implements RowMapper<Pokemon> {
    @Override
    public Pokemon mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("POKEMON_ID");
        String name = resultSet.getString("POKEMON_NAME");
        int hp = resultSet.getInt("HP");
        int attack = resultSet.getInt("ATTACK");
        int defense = resultSet.getInt("DEFENSE");
        int specialAttack = resultSet.getInt("SPECIAL_ATTACK");
        int specialDefense= resultSet.getInt("SPECIAL_DEFENSE");
        int speed = resultSet.getInt("SPEED");

        return new Pokemon(id, name, hp, attack, defense, specialAttack, specialDefense, speed);
    }
}