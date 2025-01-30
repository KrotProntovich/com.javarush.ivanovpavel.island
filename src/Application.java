import configuration.Settings;
import entity.Island;
import services.PlayIsland;


public class Application {

    public static void main(String[] args) {
        Island island = new Island(Settings.x, Settings.y);
        PlayIsland play = new PlayIsland(Settings.day, island);
        play.start();
    }
}

