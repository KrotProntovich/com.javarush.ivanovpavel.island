package entity.unit.animal.predator;

import entity.unit.animal.Animal;
import util.UnitType;

public abstract class Predator extends Animal {

    public Predator(long id, UnitType type, Integer weight, boolean eaten) {
        super(id, type, weight, eaten);
    }
}
