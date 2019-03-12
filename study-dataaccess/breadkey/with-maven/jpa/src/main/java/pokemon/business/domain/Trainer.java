package pokemon.business.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer {
    @Id
    private Integer trainerId;
    private String name;

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
