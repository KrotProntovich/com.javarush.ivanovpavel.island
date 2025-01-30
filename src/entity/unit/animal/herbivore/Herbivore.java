package entity.unit.animal.herbivore;

import entity.unit.animal.Animal;
import util.UnitType;

public class Herbivore extends Animal {
    public Herbivore(long id, UnitType type, Integer weight, boolean eaten) {
        super(id, type, weight, eaten);
    }
}
