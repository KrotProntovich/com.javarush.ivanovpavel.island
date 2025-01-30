package stat;

import configuration.Settings;
import entity.Island;
import entity.Location;
import util.UnitType;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class IslandStat implements Runnable {
   private Island island;
   private HashMap<UnitType, Integer> statIsland = new HashMap<>();
   public AtomicInteger count = new AtomicInteger(0);


    public IslandStat(Island island) {
        this.island = island;
        initialMap();
    }

    private void initialMap(){
        Set<UnitType> unitTypes = Settings.maxCountUnit.keySet();
        for (UnitType type : unitTypes){
            statIsland.put(type,0);
        }
    }

    public void printStatisticIsland() {
        islandWalking();
        System.out.println(statIsland);
    }

    private void islandWalking(){
        Location[][] locations = island.getLocations();
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                fillInMap(locations[i][j]);
            }
        }
    }

    private void fillInMap(Location location){
        Set<UnitType> unitTypes = statIsland.keySet();
        for (UnitType type : unitTypes){
            statIsland.put(type,statIsland.get(type) + location.countUnitLocation(type));
        }
    }

    @Override
    public void run() {
        if(count.get() == Settings.x*Settings.y) {
            printStatisticIsland();
            count = new AtomicInteger(0);
        }
    }
}
