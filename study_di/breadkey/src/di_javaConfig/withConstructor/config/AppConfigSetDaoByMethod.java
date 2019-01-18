package di_javaConfig.withConstructor.config;

import di_javaConfig.withConstructor.di.business.service.BaseStatsCalculateService;
import di_javaConfig.withConstructor.di.business.service.BaseStatsCalculateServiceImpl;
import di_javaConfig.withConstructor.di.business.service.PokedexService;
import di_javaConfig.withConstructor.di.business.service.PokedexServiceImpl;
import di_javaConfig.withConstructor.di.dataaccess.PokemonDao;
import di_javaConfig.withConstructor.di.dataaccess.PokemonDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class AppConfigSetDaoByMethod {
    @Bean
    public PokemonDao pokemonDao() {
        return new PokemonDaoImpl();
    }

    @Bean
    public PokedexService pokedexService() {
        return new PokedexServiceImpl(pokemonDao());
    }

    @Bean
    public BaseStatsCalculateService baseStatsCalculateService() {
        return new BaseStatsCalculateServiceImpl(pokemonDao());
    }
}
