package datasource.pokedex;

import datasource.pokedex.config.DataSourceConfig;
import datasource.pokedex.config.TemplateConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main (String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, TemplateConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        int id = 25;
        String pokemonName = jdbcTemplate.queryForObject("SELECT POKEMON_NAME FROM POKEMON WHERE POKEMON_ID=?", String.class, id);
        System.out.println(pokemonName);
    }
}
