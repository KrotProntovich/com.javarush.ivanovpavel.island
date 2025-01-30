package entity;


import configuration.Settings;
import stat.IslandStat;
import util.UnitFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Island {
    private Location[][] locations;
    private UnitFactory unitFactory = new UnitFactory();
    public CountDownLatch doneSignal = new CountDownLatch(Settings.x*Settings.y*Settings.day);

    public Island(int x, int y) {
        System.out.println("Запуск острова");
        locations = new Location[x][y];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location(i,j,this.unitFactory, locations, doneSignal);
            }
        }
    }

    public Location[][] getLocations() {
            return locations;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
