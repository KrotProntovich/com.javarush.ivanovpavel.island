package entity.unit.plant;

import configuration.Settings;
import entity.Location;
import entity.unit.Unit;
import util.UnitType;

import java.util.concurrent.ThreadLocalRandom;

public class Plant extends Unit {

    public Plant(long id, UnitType type, Integer weight, boolean eaten) {
        super(id, type, weight, eaten);
    }

//    public boolean spawn(Location location) {
//        int countPlants = location.countUnitLocation(this.getType());
//        if (countPlants < Settings.maxCountUnit.get(this.getType())) {
//            location.getLock().lock();
//            int countSpawn = ThreadLocalRandom.current().nextInt(1, countPlants);
//            for (int i = 0; i < countSpawn; i++) {
//                location.getUnitMap().add(location.getFactory().createAnimal(this.getType()));
//            }
//            location.getLock().unlock();
//            System.out.println("Добавленно:" + countSpawn + " растений");
//        }
//        return false;
//    }

    @Override
    public String toString() {
        return getType().toString() + ":" + getId();
    }
}
