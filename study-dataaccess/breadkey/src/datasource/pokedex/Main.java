package datasource.pokedex;

import datasource.pokedex.config.DataSourceConfig;
import datasource.pokedex.config.TemplateConfig;
import di_bean.pokedex.di.business.domain.Pokemon;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main (String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, TemplateConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        int id = 25;
        String pokemonName = jdbcTemplate.queryForObject("SELECT POKEMON_NAME FROM POKEMON WHERE POKEMON_ID=?", String.class, id);
        System.out.println(pokemonName);

        Pokemon pikachu = jdbcTemplate.queryForObject("SELECT * FROM POKEMON WHERE POKEMON_ID=?", new PokemonMapper(), id);
        System.out.println(pikachu.getName());
        System.out.println("공격: " + pikachu.getAttack());
        System.out.println("방어: " + pikachu.getDefense());
        System.out.println("특수공격: " + pikachu.getSpecialAttack());
        System.out.println("특수방어: " + pikachu.getSpecialDefense());
        System.out.println("스피드: " + pikachu.getSpeed());
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
