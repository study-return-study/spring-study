package datasource.pokedex;

import datasource.pokedex.config.AppConfig;
import datasource.pokedex.config.DataSourceConfig;
import datasource.pokedex.config.TemplateConfig;
import di_bean.pokedex.di.business.domain.Pokemon;
import di_bean.pokedex.di.business.service.PokedexService;
import di_bean.pokedex.di.dataaccess.PokemonDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main (String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, TemplateConfig.class, AppConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        int id = 25;
        String pokemonName = jdbcTemplate.queryForObject("SELECT POKEMON_NAME FROM POKEMON WHERE POKEMON_ID=?", String.class, id);
        System.out.println(pokemonName);

        PokedexService pokedexService = context.getBean(PokedexService.class);
        Pokemon pikachu = pokedexService.findByPokemonId(id);
        System.out.println(pikachu.getName());
        System.out.println("공격: " + pikachu.getAttack());
        System.out.println("방어: " + pikachu.getDefense());
        System.out.println("특수공격: " + pikachu.getSpecialAttack());
        System.out.println("특수방어: " + pikachu.getSpecialDefense());
        System.out.println("스피드: " + pikachu.getSpeed());
        System.out.println("종족값 총합: " + pokedexService.calculateTotalBaseStats(pikachu));
    }
}
