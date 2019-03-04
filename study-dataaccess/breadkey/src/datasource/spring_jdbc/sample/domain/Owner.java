package datasource.spring_jdbc.sample.domain;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private String ownerName;
    private List<Pet> petList;

    public Owner() {
        petList = new ArrayList<>();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Pet> getPetList() {
        return petList;
    }
}
