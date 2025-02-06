package entity;

import entity.unit.Unit;
import entity.unit.animal.Animal;
import entity.unit.animal.herbivore.Herbivore;
import entity.unit.animal.predator.*;
import entity.unit.plant.Plant;
import services.PlayIsland;
import stat.IslandStat;
import util.UnitFactory;
import util.UnitType;
import configuration.Settings;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Location implements Runnable {
    private int x;
    private int y;
    private UnitFactory factory;// фабрика полученная при создании острова
    private CopyOnWriteArrayList<Unit> unitList;// население
    private Location[][] locations;
    public ReentrantLock lock;

    public Location(int x, int y, UnitFactory factory, Location[][] locations, ReentrantLock lock) {
        this.x = x;
        this.y = y;
        this.factory = factory;
        this.locations = locations;
        this.lock = lock;
        initializationUnitList();
        //System.out.println("Рождение: " + toString());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public UnitFactory getFactory() {
        return factory;
    }

    public CopyOnWriteArrayList<Unit> getUnitList() {
        return unitList;
    }

    public void initializationUnitList() {
        unitList = new CopyOnWriteArrayList<>();
        Set<UnitType> unitTypes = Settings.maxCountUnit.keySet();
        for (UnitType type : unitTypes) {
            Unit unit = factory.createAnimal(type);
            if (unit instanceof Predator) {
                unitList.add(unit);
                for (int j = 0; j < Settings.predator - 1; j++) {
                    unitList.add(factory.createAnimal(type));
                }
            }
            if (unit instanceof Herbivore) {
                unitList.add(unit);
                for (int j = 0; j < Settings.herbivorous - 1; j++) {
                    unitList.add(factory.createAnimal(type));
                }
            }
            if (unit instanceof Plant) {
                unitList.add(unit);
                for (int j = 0; j < Settings.plants - 1; j++) {
                    unitList.add(factory.createAnimal(type));
                }
            }
        }
    }

    public int countUnitLocation(UnitType type) {
        int countType = 0;
            for (int i = 0; i < unitList.size()-1; i++) {
                if (unitList.get(i).getType().equals(type)) countType++;
            }
        return countType;
    }

    @Override
    public String toString() {
        return "Location " + x + ":" + y;
    }

    @Override
    public void run() {
        ConcurrentLinkedQueue<Animal> que = new ConcurrentLinkedQueue<>();
        //System.out.println("-".repeat(50)+Thread.currentThread().getName() + this.toString());
        for (int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i) instanceof Animal animal) {
                que.add(animal);
            }
        }
        while (que.size() > 0) {
            Animal poll;
            if ((poll = que.poll()) != null) {
                if (!poll.die(this) && !poll.isEaten()) {
                    if (poll.eat(this)) poll.reproduce(this);
                    poll.move(this, locations);
                }
            }
        }
        //System.out.println(this.toString() + unitList);
        PlayIsland.doneSignal.countDown();
    }
}
