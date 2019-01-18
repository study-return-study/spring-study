package di_annotation.pokedex;

import di_annotation.pokedex.di.business.domain.Pokemon;
import di_annotation.pokedex.di.business.service.PokedexService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PokedexRun {
    public static void main(String[] args) {
        PokedexRun run = new PokedexRun();
        run.execute();
    }

    public void execute() {
        BeanFactory context = new ClassPathXmlApplicationContext("/di_annotation/pokedex/config/applicationContext.xml");
        PokedexService pokedexService = context.getBean(PokedexService.class);
        Pokemon pikachu = pokedexService.findByPokemonId(25);
        int totalBaseStats = pokedexService.calculateTotalBaseStats(pikachu);

        System.out.println(pikachu.getName() + "의 종족값 총합은 " + totalBaseStats + "입니다.");
    }
}
