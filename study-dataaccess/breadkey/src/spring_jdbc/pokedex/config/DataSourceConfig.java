package spring_jdbc.pokedex.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@PropertySource("jdbc.properties")
public class DataSourceConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.maxPoolSize}")
    private int maxPoolSize;

    @Bean
    public DataSource pokedexDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxTotal(maxPoolSize);

        dataInitialize(dataSource);

        return dataSource;
    }

    private void dataInitialize(DataSource dataSource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(
                new ClassPathResource("/script/pokedex-table.sql"),
                new ClassPathResource("/script/pokedex-data.sql")
        );
        populator.execute(dataSource);
    }
}
