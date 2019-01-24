package aop_javaConfig.config;

import aop_annotation.pokedex.business.domain.Pokemon;
import aop_annotation.pokedex.business.service.PokedexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PokedexRun {
    public static void main(String[] args) {
        PokedexRun run = new PokedexRun();
        run.execute();
    }

    public void execute() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PokedexService pokedexService = context.getBean(PokedexService.class);
        pokedexService.addPokemon(new Pokemon(
                151,
                "뮤",
                100,
                100,
                100,
                100,
                100,
                100
        ));
        Pokemon mew = pokedexService.findPokemonById(151);
    }
}
