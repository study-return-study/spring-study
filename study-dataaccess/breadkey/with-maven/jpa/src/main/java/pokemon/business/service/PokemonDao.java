package pokemon.business.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pokemon.business.domain.Pokemon;
import pokemon.business.domain.Trainer;

import java.util.List;

@Repository
public interface PokemonDao extends JpaRepository<Pokemon, Integer> {
    @Query
    List<Pokemon> findAllByTrainer(Trainer trainer);
}
