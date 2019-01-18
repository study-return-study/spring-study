package di_javaConfig.withConstructor;

import di_javaConfig.withConstructor.config.AppConfigSetDaoByAutowire;
import di_javaConfig.withConstructor.config.AppConfigSetDaoByMethod;
import di_javaConfig.withConstructor.config.AppConfigSetDaoByParameter;
import di_javaConfig.withConstructor.di.business.domain.Pokemon;
import di_javaConfig.withConstructor.di.business.service.BaseStatsCalculateService;
import di_javaConfig.withConstructor.di.business.service.PokedexService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PokedexRun {
    public static void main(String[] args) {
        PokedexRun run = new PokedexRun();
        run.executeSetDaoByParameter();
        run.executeSetDaoByMethod();
        run.excuteSetDaoByAutowire();
    }

    public void executeSetDaoByParameter() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigSetDaoByParameter.class);
        PokedexService pokedexService = context.getBean(PokedexService.class);
        Pokemon pikachu = pokedexService.findByPokemonId(25);

        System.out.println(pikachu.getName());
    }

    public void executeSetDaoByMethod() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigSetDaoByMethod.class);
        PokedexService pokedexService = context.getBean(PokedexService.class);
        Pokemon pikachu = pokedexService.findByPokemonId(25);
        BaseStatsCalculateService baseStatsCalculateService = context.getBean(BaseStatsCalculateService.class);
        int totalBaseStats = baseStatsCalculateService.calculateTotalBaseStatsById(25);

        System.out.println(pikachu.getName() + "의 종족값 총합은 " + totalBaseStats + "입니다.");
    }

    public void excuteSetDaoByAutowire() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigSetDaoByAutowire.class);
        PokedexService pokedexService = context.getBean(PokedexService.class);
        Pokemon pikachu = pokedexService.findByPokemonId(25);

        System.out.println(pikachu.getName());
    }
}
