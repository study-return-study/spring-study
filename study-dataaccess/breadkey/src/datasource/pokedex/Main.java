package datasource.pokedex;

import datasource.pokedex.config.AppConfig;
import datasource.pokedex.config.DataSourceConfig;
import datasource.pokedex.config.TemplateConfig;
import di_bean.pokedex.di.business.domain.Pokemon;
import di_bean.pokedex.di.business.service.PokedexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, TemplateConfig.class, AppConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        int id = 25;
        String pokemonName = jdbcTemplate.queryForObject("SELECT POKEMON_NAME FROM POKEMON WHERE POKEMON_ID=?", String.class, id);
        System.out.println(pokemonName);

        PokedexService pokedexService = context.getBean(PokedexService.class);
        Pokemon pikachu = pokedexService.findByPokemonId(id);
        printStats(pikachu, pokedexService);

        List<Pokemon> pokemonList = pokedexService.findAllPokemons();
        for (Pokemon pokemon : pokemonList) {
            printStats(pokemon, pokedexService);
        }

        Pokemon charmander = new Pokemon(4, "파이리", 39, 52, 43, 60, 50, 65);
        pokedexService.addPokemon(charmander);
        printStats(pokedexService.findByPokemonId(4), pokedexService);

        List<Pokemon> squrirtles = new ArrayList<>();
        squrirtles.add(new Pokemon(7, "꼬부기", 44, 48, 65, 50, 64, 43));
        squrirtles.add(new Pokemon(8, "어니부기", 59, 63, 80, 65, 80, 58));
        squrirtles.add(new Pokemon(9, "거북왕", 79, 83, 100, 85, 105, 78));

        pokedexService.addPokemons(squrirtles);
        printStats(pokedexService.findByPokemonId(7), pokedexService);
        printStats(pokedexService.findByPokemonId(8), pokedexService);
        printStats(pokedexService.findByPokemonId(9), pokedexService);
    }

    private static void printStats(Pokemon pokemon, PokedexService pokedexService) {
        System.out.println(pokemon.getPokemonId() + ". " + pokemon.getPokemonName());
        System.out.println("HP: " + pokemon.getHp());
        System.out.println("공격: " + pokemon.getAttack());
        System.out.println("방어: " + pokemon.getDefense());
        System.out.println("특수공격: " + pokemon.getSpecialAttack());
        System.out.println("특수방어: " + pokemon.getSpecialDefense());
        System.out.println("스피드: " + pokemon.getSpeed());
        System.out.println("종족값 총합: " + pokedexService.calculateTotalBaseStats(pokemon));
    }
}
