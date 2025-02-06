package services;

import configuration.Settings;
import entity.Island;
import entity.Location;
import stat.IslandStat;

import java.util.concurrent.*;

public class PlayIsland {
    private Island island;
    public static CountDownLatch doneSignal = new CountDownLatch(Settings.countDown);

    public PlayIsland() {
        this.island = new Island(Settings.x, Settings.y);
    }

    public void start() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        ExecutorService executorS = Executors.newFixedThreadPool(4);
        IslandStat islandStat = new IslandStat(island);

        for (int k = 0; k < Settings.day; k++) {
            executor.scheduleWithFixedDelay(new PlantsTasks(island.getLocations()), 0L, 500L, TimeUnit.MILLISECONDS);
            if (k < Settings.day && doneSignal.getCount() == 0) {
                doneSignal = new CountDownLatch(Settings.countDown);
            }
            executorS.execute(islandStat);
            Location[][] locations = island.getLocations();
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length; j++) {
                    executorS.execute(locations[i][j]);
                }
            }
            try {
                doneSignal.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        executorS.shutdownNow();
        executor.shutdownNow();
    }
}
