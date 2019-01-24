package aop_javaConfig.config;

import aop_annotation.pokedex.MyFirstAspect;
import aop_annotation.pokedex.business.service.PokedexService;
import aop_annotation.pokedex.business.service.PokedexServiceImpl;
import aop_annotation.pokedex.business.service.PokemonDao;
import aop_annotation.pokedex.dataaccess.PokemonDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public PokedexService pokedexService() {
        return new PokedexServiceImpl();
    }

    @Bean
    public PokemonDao pokemonDao() {
        return new PokemonDaoImpl();
    }

    @Bean
    public MyFirstAspect myFirstAspect() {
        return new MyFirstAspect();
    }
}
