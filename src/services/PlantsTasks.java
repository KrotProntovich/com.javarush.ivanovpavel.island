package services;

import configuration.Settings;
import entity.Location;
import util.UnitType;

import java.util.concurrent.ThreadLocalRandom;

public class PlantsTasks implements Runnable {
    private Location[][] locations;

    public PlantsTasks(Location[][] locations) {
        this.locations = locations;
    }

    public void doTasks(){
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                int countSpawn = ThreadLocalRandom.current().nextInt(1, 15);
                int countPlants = locations[i][j].countUnitLocation(UnitType.PLANT);
                if (countPlants+countSpawn < Settings.maxCountUnit.get(UnitType.PLANT)) {
                    for (int k = 0; k < countSpawn; k++) {
                        locations[i][j].getUnitList().add(locations[i][j].getFactory().createAnimal(UnitType.PLANT));
                    }
                }
                //System.out.println("Добавленно:" + countSpawn + " растений");
            }
        }
    }

    @Override
    public void run() {
        doTasks();
    }
}
