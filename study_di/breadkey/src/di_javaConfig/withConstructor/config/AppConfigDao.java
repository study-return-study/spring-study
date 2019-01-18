package di_javaConfig.withConstructor.config;

import di_javaConfig.withConstructor.di.dataaccess.PokemonDao;
import di_javaConfig.withConstructor.di.dataaccess.PokemonDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigDao {
    @Bean
    public PokemonDao pokemonDao() {
        return new PokemonDaoImpl();
    }
}
