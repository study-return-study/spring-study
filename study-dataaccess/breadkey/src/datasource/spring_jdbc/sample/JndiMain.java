package datasource.spring_jdbc.sample;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

import javax.sql.DataSource;

public class JndiMain {
    public static void main (String[] args) throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSource.setUrl("jdbc:hsqldb:mem:jdbc");
        dataSource.setUsername("breadkey");
        dataSource.setPassword("");
        dataInitialize(dataSource);

        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
        builder.bind("jdbc/MyDataSource", dataSource);
        builder.activate();

        ApplicationContext context = new ClassPathXmlApplicationContext("datasource/spring_jdbc/sample/config/spring-jndi.xml");

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PET", Integer.class);
        System.out.println(count);
    }

    private static void dataInitialize(DataSource dataSource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(
                new ClassPathResource("/script/table.sql"),
                new ClassPathResource("/script/data.sql")
        );
        populator.execute(dataSource);
    }
}
