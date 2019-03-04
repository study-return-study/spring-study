package datasource.jdbc;

import datasource.jdbc.config.DataSourceConfig;
import datasource.jdbc.config.TemplateConfig;
import datasource.jdbc.domain.Owner;
import datasource.jdbc.domain.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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

        List<Pet> pets = jdbcTemplate.query("SELECT * FROM PET WHERE OWNER_NAME=?", new BeanPropertyRowMapper<Pet>(Pet.class), ownerName);
        for (Pet p : pets) {
            System.out.println(p.getPetName());
        }

        Owner owner = jdbcTemplate.query("SELECT * FROM OWNER O INNER JOIN PET P ON O.OWNER_NAME = P.OWNER_NAME WHERE O.OWNER_NAME=?",
                new ResultSetExtractor<Owner>() {
                    @Override
                    public Owner extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        if (!resultSet.next()) {
                            return null;
                        }
                        Owner owner = new Owner();
                        owner.setOwnerName(resultSet.getString("OWNER_NAME"));
                        do {
                            Pet pet = new Pet();
                            pet.setPetId(resultSet.getInt("PET_ID"));
                            pet.setPetName(resultSet.getString("PET_NAME"));
                            pet.setOwnerName(resultSet.getString("OWNER_NAME"));
                            pet.setPrice(resultSet.getInt("PRICE"));
                            pet.setBirthDate(resultSet.getDate("BIRTH_DATE"));
                            owner.getPetList().add(pet);
                        } while (resultSet.next());

                        return owner;
                    }
                },
                ownerName);
        System.out.println(owner.getPetList().size());

        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate.getDataSource())
                .withProcedureName("CALC_PET_PRICE")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new SqlParameter("IN_PET_ID", Types.INTEGER),
                        new SqlOutParameter("OUT_PRICE", Types.INTEGER)
                );
        MapSqlParameterSource in = new MapSqlParameterSource().addValue("IN_PET_ID", id);
        Map<String, Object> out = call.execute(in);
        int price = (int) out.get("OUT_PRICE");
        System.out.println(price);
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