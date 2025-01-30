package entity.unit.animal.herbivore;

import util.UnitType;

public class Duck extends Herbivore{
    public Duck(long id, UnitType type, Integer weight, boolean eaten) {
        super(id, type, weight, eaten);
    }
}
