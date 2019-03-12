package pokemon.business.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Pokemon {
    @Id
    private Integer pokemonId;
    @ManyToOne
    @JoinColumn(name = "index_number")
    private PokemonSpec pokemonSpec;
    private Date birthDate;
    private Integer level;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Integer getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public PokemonSpec getPokemonSpec() {
        return pokemonSpec;
    }

    public void setPokemonSpec(PokemonSpec pokemonSpec) {
        this.pokemonSpec = pokemonSpec;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
