import entity.Island;
import entity.Location;
import stat.IslandStat;
import util.UnitType;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlayIsland {
    private int day;
    private Island island;

    public PlayIsland(int day, Island island) {
        this.day = day;
        this.island = island;
    }

    public void start() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        Location[][] locations = island.getLocations();
        IslandStat islandStat = new IslandStat(island);
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                PlantsTasks plantsTasks = new PlantsTasks(locations[i][j], locations[i][j].countUnitLocation(UnitType.PLANT));
                executor.scheduleWithFixedDelay(plantsTasks, 0L, 2L, TimeUnit.SECONDS);
                executor.scheduleWithFixedDelay(locations[i][j], 0L, 2L, TimeUnit.SECONDS);
            }
        }
        executor.scheduleWithFixedDelay(islandStat,2L,2L, TimeUnit.SECONDS);
        try {
            island.doneSignal.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.close();
    }
}
