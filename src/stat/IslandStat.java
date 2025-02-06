package stat;

import configuration.Settings;
import entity.Island;
import entity.Location;
import services.PlayIsland;
import util.UnitType;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


public class IslandStat implements Runnable {
    private Island island;
    public AtomicInteger count = new AtomicInteger(1);
    private HashMap<UnitType, Integer> countUnit;

    public IslandStat(Island island) {
        this.island = island;
    }

    public void printStatisticIsland() {
        Set<UnitType> unitTypes = Settings.maxCountUnit.keySet();
        countUnit = new HashMap<>();
        for(UnitType type : unitTypes){
            countUnit.put(type,0);
        }

        Location[][] locations = island.getLocations();
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].lock.lock();
                for (UnitType type : unitTypes){
                    countUnit.put(type,countUnit.get(type) + locations[i][j].countUnitLocation(type));
                }
                locations[i][j].lock.unlock();
            }
        }
        System.out.println(countUnit);
    }

    @Override
    public void run() {
        //System.out.println("-".repeat(50) + "Начало дня" + "-".repeat(50));
        while (PlayIsland.doneSignal.getCount() > 1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("-".repeat(50) + "Прощел день: " + count.get() + "-".repeat(50));
        printStatisticIsland();
        count.incrementAndGet();
        PlayIsland.doneSignal.countDown();
    }
}
