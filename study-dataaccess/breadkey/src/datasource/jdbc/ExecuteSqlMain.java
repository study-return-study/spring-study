package datasource.jdbc;

import datasource.jdbc.config.DataSourceConfig;
import datasource.jdbc.config.TemplateConfig;
import datasource.jdbc.domain.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExecuteSqlMain {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("datasource/config/spring-db.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, TemplateConfig.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);

        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PET", Integer.class);
        System.out.println(count);

        String ownerName = "홍길동";
        count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PET WHERE OWNER_NAME=?", Integer.class, ownerName);
        System.out.println(count);

        int id = 1;
        count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROm PET WHERE PET_ID=?", Integer.class, id);
        System.out.println(count);

        Date birthData = jdbcTemplate.queryForObject("SELECT BIRTH_DATE FROM PET WHERE PET_ID=?", Date.class, id);
        System.out.println(birthData);

        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM PET WHERE PET_ID=?", id);
        System.out.println(map.get("PET_NAME"));
        System.out.println(map.get("OWNER_NAME"));

        List<Map<String, Object>> petList = jdbcTemplate.queryForList("SELECT * FROM PET WHERE OWNER_NAME=?", ownerName);
        System.out.println(petList.get(0).get("PET_NAME"));

        List<Integer> priceList = jdbcTemplate.queryForList("SELECT PRICE FROM PET WHERE OWNER_NAME=?", Integer.class, ownerName);
        System.out.println(priceList);

        Pet pet = jdbcTemplate.queryForObject(
                "SELECT * FROM PET WHERE PET_ID=?",
                new PetRowMapper(),
                id
        );

        System.out.println(
                pet.getPetId() + " " + pet.getPetName() + " " + pet.getOwnerName() + " " + pet.getBirthDate() + " " + pet.getPrice()
        );
    }
}

class PetRowMapper implements RowMapper<Pet> {
    @Override
    public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
        Pet pet = new Pet();
        pet.setPetId(resultSet.getInt("PET_ID"));
        pet.setPetName(resultSet.getString("PET_NAME"));
        pet.setOwnerName(resultSet.getString("OWNER_NAME"));
        pet.setPrice(resultSet.getInt("PRICE"));
        pet.setBirthDate(resultSet.getDate("BIRTH_DATE"));

        return pet;
    }
}