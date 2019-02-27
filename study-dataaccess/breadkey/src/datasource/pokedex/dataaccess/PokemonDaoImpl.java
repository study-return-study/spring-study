package datasource.pokedex.dataaccess;

import di_bean.pokedex.di.business.domain.Pokemon;
import di_bean.pokedex.di.dataaccess.PokemonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PokemonDaoImpl implements PokemonDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    /*
    public void addPokemon(Pokemon pokemon) {
        jdbcTemplate.update("INSERT INTO POKEMON (POKEMON_ID, POKEMON_NAME, HP, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                pokemon.getPokemonId(), pokemon.getPokemonName(), pokemon.getHp(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecialAttack(), pokemon.getSpecialDefense(), pokemon.getSpeed());
    }
    */

    /*
    public void addPokemon(Pokemon pokemon) {
        namedParameterJdbcTemplate.update("INSERT INTO POKEMON (POKEMON_ID, POKEMON_NAME, HP, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED)" +
                " VALUES (:POKEMON_ID, :POKEMON_NAME, :HP, :ATTACK, :DEFENSE, :SPECIAL_ATTACK, :SPECIAL_DEFENSE, :SPEED)",
                new MapSqlParameterSource()
                .addValue("POKEMON_ID", pokemon.getPokemonId())
                .addValue("POKEMON_NAME", pokemon.getPokemonName())
                .addValue("HP", pokemon.getHp())
                .addValue("ATTACK", pokemon.getAttack())
                .addValue("DEFENSE", pokemon.getDefense())
                .addValue("SPECIAL_ATTACK", pokemon.getSpecialAttack())
                .addValue("SPECIAL_DEFENSE", pokemon.getSpecialDefense())
                .addValue("SPEED", pokemon.getSpeed())
                );
    }
    */
    public void addPokemon(Pokemon pokemon) {
        BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(pokemon);

        namedParameterJdbcTemplate.update("INSERT INTO POKEMON (POKEMON_ID, POKEMON_NAME, HP, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED)" +
                " VALUES (:pokemonId, :pokemonName, :hp, :attack, :defense, :specialAttack, :specialDefense, :speed)",
                beanPropertySqlParameterSource);
    }

    @Override
    public Pokemon findByPokemonId(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM POKEMON WHERE POKEMON_ID=?", new PokemonMapper(), id);
    }

    @Override
    public List<Pokemon> findAllPokemons() {
        return jdbcTemplate.query("SELECT* FROM POKEMON", new BeanPropertyRowMapper<Pokemon>(Pokemon.class));
    }

    @Override
    /*
    public void addPokemons(List<Pokemon> pokemons) {
        int[] num = jdbcTemplate.batchUpdate(
                "INSERT INTO POKEMON (POKEMON_ID, POKEMON_NAME, HP, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setInt(1, pokemons.get(i).getPokemonId());
                        preparedStatement.setString(2, pokemons.get(i).getPokemonName());
                        preparedStatement.setInt(3, pokemons.get(i).getHp());
                        preparedStatement.setInt(4, pokemons.get(i).getAttack());
                        preparedStatement.setInt(5, pokemons.get(i).getDefense());
                        preparedStatement.setInt(6, pokemons.get(i).getSpecialAttack());
                        preparedStatement.setInt(7, pokemons.get(i).getSpecialDefense());
                        preparedStatement.setInt(8, pokemons.get(i).getSpeed());
                    }

                    @Override
                    public int getBatchSize() {
                        return pokemons.size();
                    }
                }
        );
    }
    */

    public void addPokemons(List<Pokemon> pokemons) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(pokemons.toArray());
        int[] num = namedParameterJdbcTemplate.batchUpdate(
                "INSERT INTO POKEMON (POKEMON_ID, POKEMON_NAME, HP, ATTACK, DEFENSE, SPECIAL_ATTACK, SPECIAL_DEFENSE, SPEED)" +
                        " VALUES (:pokemonId, :pokemonName, :hp, :attack, :defense, :specialAttack, :specialDefense, :speed)",
                batch
        );
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