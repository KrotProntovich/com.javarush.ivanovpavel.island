package services;

import configuration.Settings;
import entity.Location;
import util.UnitType;

import java.util.concurrent.ThreadLocalRandom;

public class PlantsTasks implements Runnable {
    private Location location;
    private int countPlants;

    public PlantsTasks(Location location, int countPlants) {
        this.location = location;
        this.countPlants = countPlants;
    }

    public void doTasks(){
        int countSpawn = ThreadLocalRandom.current().nextInt(1, 15);
        if (countPlants+countSpawn < Settings.maxCountUnit.get(UnitType.PLANT)) {
            for (int i = 0; i < countSpawn; i++) {
                location.getUnitList().add(location.getFactory().createAnimal(UnitType.PLANT));
            }
        }
            //System.out.println("Добавленно:" + countSpawn + " растений");
    }

    @Override
    public String toString() {
        return "services.PlantsTasks";
    }

    @Override
    public void run() {
        doTasks();
    }
}
