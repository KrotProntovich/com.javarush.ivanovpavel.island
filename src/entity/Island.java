package entity;


import util.UnitFactory;
import java.util.concurrent.locks.ReentrantLock;

public class Island {
    private Location[][] locations;
    private UnitFactory  unitFactory;
    public ReentrantLock lock =  new ReentrantLock();


    public Island(int x, int y) {
        System.out.println("Запуск острова");
        unitFactory = new UnitFactory();
        locations = new Location[x][y];
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = new Location(i,j,this.unitFactory, locations, lock);
            }
        }
    }

    public Location[][] getLocations() {
            return locations;
    }
}
