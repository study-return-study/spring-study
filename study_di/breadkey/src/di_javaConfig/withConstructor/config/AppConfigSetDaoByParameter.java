package di_javaConfig.withConstructor.config;

import di_javaConfig.withConstructor.di.business.service.PokedexService;
import di_javaConfig.withConstructor.di.business.service.PokedexServiceImpl;
import di_javaConfig.withConstructor.di.dataaccess.PokemonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfigDao.class)
public class AppConfigSetDaoByParameter {
    @Bean
    public PokedexService pokedexService(PokemonDao pokemonDao) {
        return new PokedexServiceImpl(pokemonDao);
    }
}
