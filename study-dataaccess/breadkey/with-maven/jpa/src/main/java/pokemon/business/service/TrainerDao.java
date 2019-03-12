package pokemon.business.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pokemon.business.domain.Trainer;

@Repository
public interface TrainerDao extends JpaRepository<Trainer, Integer> {
    @Query
    Trainer findByName(String name);
}
