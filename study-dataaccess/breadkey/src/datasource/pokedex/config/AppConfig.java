package datasource.pokedex.config;

import datasource.pokedex.dataaccess.PokemonDaoImpl;
import di_bean.pokedex.di.dataaccess.PokemonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PokemonDao pokemonDao() {
        return new PokemonDaoImpl();
    }
}
