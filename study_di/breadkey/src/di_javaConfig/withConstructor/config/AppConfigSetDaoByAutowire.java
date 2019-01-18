package di_javaConfig.withConstructor.config;

import di_javaConfig.withConstructor.di.business.service.PokedexService;
import di_javaConfig.withConstructor.di.business.service.PokedexServiceImpl;
import di_javaConfig.withConstructor.di.dataaccess.PokemonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfigDao.class)
public class AppConfigSetDaoByAutowire {
    @Autowired
    private PokemonDao pokemonDao;

    @Bean
    public PokedexService pokedexService() {
        return new PokedexServiceImpl(pokemonDao);
    }
}
