package entity.unit.animal.herbivore;

import entity.Location;
import entity.unit.Unit;
import entity.unit.animal.Animal;
import util.UnitType;

public class Caterpillar extends Herbivore {

    public Caterpillar(long id, UnitType type, Integer weight, boolean eaten) {
        super(id, type, weight, eaten);
    }

    @Override
    public boolean eat(Location location) {
        Unit unit = searchEat(location);
        if (unit != null) {
            // проверка
            //System.out.println(toString() + " съел " + unit.toString());
            return true;
        } else {
            // проверка
            //System.out.println(toString() + " остался голодным");
            return false;
        }
    }

    @Override
    public void reproduce(Location location) {
            Animal unit = searchPartner(location);
            if (unit != null) {
                location.getUnitList().add(location.getFactory().createAnimal(this.getType()));
                // проверка
                //System.out.println(this.toString() + " размножился с " + unit.toString());
            } else {
                // проверка
               //System.out.println(this.toString() + " не размножился");
            }
    }

    @Override
    public void move(Location location, Location[][] locations) {
    }
}
