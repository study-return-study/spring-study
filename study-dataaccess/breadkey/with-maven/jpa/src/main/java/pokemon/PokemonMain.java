package pokemon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pokemon.business.domain.Pokemon;
import pokemon.business.domain.PokemonSpec;
import pokemon.business.domain.Trainer;
import pokemon.business.service.PokemonDao;
import pokemon.business.service.PokemonSpecDao;
import pokemon.business.service.TrainerDao;
import pokemon.config.DataSourceConfig;
import pokemon.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;

public class PokemonMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, JpaConfig.class);
        PokemonSpecDao pokemonSpecDao = context.getBean(PokemonSpecDao.class);

        PokemonSpec pikachuSpec = pokemonSpecDao.findByIndexNumber(25);
        System.out.println(pikachuSpec.getName());

        Trainer satoshi = new Trainer();
        satoshi.setTrainerId(1);
        satoshi.setName("지우");

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(satoshi);

        Pokemon pikachu = new Pokemon();
        pikachu.setPokemonId(1);
        pikachu.setPokemonSpec(pikachuSpec);
        pikachu.setLevel(5);
        pikachu.setTrainer(satoshi);
        pikachu.setBirthDate(new Date());

        entityManager.persist(pikachu);

        transaction.commit();

        TrainerDao trainerDao = context.getBean(TrainerDao.class);
        satoshi = trainerDao.findByName("지우");
        PokemonDao pokemonDao = context.getBean(PokemonDao.class);
        List<Pokemon> pokemonsOfSatoshi = pokemonDao.findAllByTrainer(satoshi);
        for (Pokemon pokemon : pokemonsOfSatoshi) {
            if (pokemon.getPokemonSpec().getIndexNumber() == 25) {
                pikachu = pokemon;
                break;
            }
        }

        System.out.println(pikachu.getTrainer().getName());
    }
}
