package di_javaConfig;

import di_bean.pokedex.di.business.domain.Pokemon;
import di_bean.pokedex.di.business.service.PokedexService;
import di_javaConfig.config.AppConfig;
import di_javaConfig.config.AppConfigWithComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PokedexRun {
    public static void main(String[] args) {
        PokedexRun run = new PokedexRun();
        run.execute();
        run.executeWithComponentScan();
    }

    public void execute() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PokedexService pokedexService = context.getBean(PokedexService.class);
        Pokemon pikachu = pokedexService.findByPokemonId(25);
        int totalBaseStats = pokedexService.calculateTotalBaseStats(pikachu);

        System.out.println(pikachu.getName() + "의 종족값 총합은 " + totalBaseStats + "입니다.");
    }

    public void executeWithComponentScan() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigWithComponentScan.class);
        di_annotation.pokedex.di.business.service.PokedexService pokedexService = context.getBean(di_annotation.pokedex.di.business.service.PokedexService.class);
        di_annotation.pokedex.di.business.domain.Pokemon pikachu = pokedexService.findByPokemonId(25);
        int totalBaseStats = pokedexService.calculateTotalBaseStats(pikachu);

        System.out.println(pikachu.getName() + "의 종족값 총합은 " + totalBaseStats + "입니다.");
    }
}
