package di_javaConfig.config;

import di_bean.pokedex.di.business.service.PokedexService;
import di_bean.pokedex.di.business.service.PokedexServiceImpl;
import di_bean.pokedex.di.dataaccess.PokemonDao;
import di_bean.pokedex.di.dataaccess.PokemonDaoImpl;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(autowire = Autowire.BY_TYPE)
    public PokedexService pokedexService() {
        return new PokedexServiceImpl();
    }

    @Bean
    public PokemonDao pokemonDao() {
        return new PokemonDaoImpl();
    }
}
