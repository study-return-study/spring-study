package aop_annotation.pokedex;

import aop_annotation.pokedex.business.domain.Pokemon;
import aop_annotation.pokedex.business.service.PokedexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PokedexRun {
    public static void main(String[] args) {
        PokedexRun run = new PokedexRun();
        run.execute();
    }

    public void execute() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/aop_annotation/config/applicationContext.xml");
        PokedexService pokedexService = context.getBean(PokedexService.class);

        pokedexService.addPokemon(new Pokemon(
                25,
                "피카츄",
                45,
                55
                ,50
                ,50
                ,50
                ,90
        ));

        Pokemon pikachu = pokedexService.findPokemonById(25);
    }
}
