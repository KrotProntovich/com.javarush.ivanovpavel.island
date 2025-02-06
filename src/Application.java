import configuration.Settings;
import entity.Island;
import services.PlayIsland;


public class Application {

    public static void main(String[] args) {
        PlayIsland play = new PlayIsland();
        play.start();
    }
}

