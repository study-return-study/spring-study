package pokemon.business.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pokemon.business.domain.PokemonSpec;

@Repository
public interface PokemonSpecDao extends JpaRepository<PokemonSpec, Integer> {
    @Query
    PokemonSpec findByIndexNumber(Integer indexNumber);
}
