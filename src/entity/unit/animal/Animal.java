package entity.unit.animal;

import configuration.Settings;
import entity.Location;
import entity.unit.Unit;
import entity.unit.animal.predator.Wolf;
import util.Direction;
import util.UnitType;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Animal extends Unit {

    private ThreadLocalRandom current = ThreadLocalRandom.current();

    public Animal(long id, UnitType type, Integer weight, boolean eaten) {
        super(id, type, weight , eaten);
    }

    // метод есть
    public boolean eat(Location location) {
        Unit unit = searchEat(location);
        if (unit != null) {
            // проверка
            //System.out.println(toString() + " съел " + unit.toString());
            this.increaseSatiety(unit);
            return true;
        } else {
            this.decreaseSatiety();
            // проверка
            //System.out.print(toString() + " остался голодным" + " ");
            return false;
        }
    }

    // поиск еды
    public Unit searchEat(Location location) {
        HashMap<Integer, UnitType> eatUnitStatistic = switch (this.getType()) {
            case WOLF -> Settings.eatWolfStatistic;
            case BOA -> Settings.eatBoaStatistic;
            case FOX -> Settings.eatFoxStatistic;
            case BEAR -> Settings.eatBearStatistic;
            case EAGLE -> Settings.eatEagleStatistic;
            case HORSE -> Settings.eatHorseStatistic;
            case DEER -> Settings.eatDeerStatistic;
            case RABBIT -> Settings.eatRabbitStatistic;
            case MOUSE -> Settings.eatMouseStatistic;
            case GOAT -> Settings.eatGoatStatistic;
            case SHEEP -> Settings.eatSheepStatistic;
            case BOAR -> Settings.eatBoarStatistic;
            case BUFFALO -> Settings.eatBuffaloStatistic;
            case DUCK -> Settings.eatDuckStatistic;
            case CATERPILLAR -> Settings.eatCaterpillarStatistic;
            case PLANT -> null;
        };
        Unit unit = null;// возвращаемый результат;
        int i = 100 - current.nextInt(1, 101);// получаем число вероятность поедания
        Set<Integer> integers = eatUnitStatistic.keySet();// получаем коллекцию вероятности поедания конкретного типа
        List<UnitType> menu = new ArrayList<>();// составляем меню из типов сущностей
        for (Integer key : integers) {
            if (i < key) menu.add(eatUnitStatistic.get(key));
        }
        if (!menu.isEmpty()) {
            int j = current.nextInt(0, menu.size());
            List<Unit> units = location.getUnitList();
            for (int k = 0; k < units.size(); k++) {
                if (units.get(k).getType().equals(menu.get(j))) {
                    units.get(k).setEaten(true);
                    unit = units.remove(k);
                    break;
                }
            }
        }
        return unit;
    }

    // метод размножаться
    public void reproduce(Location location) {
            Animal unit = searchPartner(location);
            if (unit != null && location.countUnitLocation(this.getType())<Settings.maxCountUnit.get(this.getType())) {
                location.getUnitList().add(location.getFactory().createAnimal(this.getType()));
                // проверка
                //System.out.print(this.toString() + " размножился с " + unit.toString()+ " ");
                this.decreaseSatiety();
                unit.decreaseSatiety();

            }
            // проверка
//            else {
//                System.out.print(this.toString() + " не размножился"+ " ");
//            }
    }

    // поиск партнера
    public Animal searchPartner(Location location) {
        Animal unit = null;
        List<Unit> units = location.getUnitList();
        List<Unit> thisTypeUnit = new ArrayList<>();
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).getType().equals(this.getType())) thisTypeUnit.add(units.get(i));
        }
        //System.out.println(thisTypeUnit);
        if (!thisTypeUnit.isEmpty() && thisTypeUnit.size() < Settings.maxCountUnit.get(this.getType())) {
            int partner = 0;
            if (thisTypeUnit.size() != 0) partner = current.nextInt(thisTypeUnit.size());
            if (thisTypeUnit.get(partner).getId() != this.getId()) {
                try {
                    unit = (Animal) thisTypeUnit.get(partner);
                } catch (ClassCastException e) {
                    System.out.println("Класс Animal метод searchPartner");
                }
            }
        }
        return unit;
    }

    // метод передвигаться параметры массив ходов и локация в которой оно находится
    public void move(Location location, Location[][] locations) {
        int[] coordinates = searchLocation(location.getX(), location.getY());
        if (coordinates[0] != 0 || coordinates[1] != 0) {
            int x = coordinates[0];
            int y = coordinates[1];
            Location newlocation = locations[x][y];
            if (newlocation.countUnitLocation(this.getType()) < Settings.maxCountUnit.get(this.getType())) {
                newlocation.getUnitList().add(this);
                location.getUnitList().remove(this);
                // проверка
                //System.out.println(this.toString() + " переехал на " + newlocation.toString());
                this.decreaseSatiety();
            }
            // проверка
//            else
//                System.out.println(this.toString() + "На локации нет места");
        }
        // проверка
//        else {
//            System.out.println(this.toString() + "Локация не найдена");
//        }
    }

    // поиск локации
    private int[] searchLocation(int x, int y) {
        int[] coordinates = new int[2];// создание массива под координаты
        Direction[] values = Direction.values();// получение массива направлений
        int direction = current.nextInt(0, values.length);// получение направления
        // заполнение массива координат
        int countSteps = current.nextInt(1, Settings.maxCountStepsAnimal.get(this.getType()) + 1);
        if (values[direction].equals(Direction.UP)) {
            int newX = x - countSteps;
            if (newX >= 0) {
                coordinates[0] = newX;
                coordinates[1] = y;
            }
        }
        if (values[direction].equals(Direction.DOWN)) {
            int newX = x + countSteps;
            if (newX < Settings.x) {
                coordinates[0] = newX;
                coordinates[1] = y;
            }
        }
        if (values[direction].equals(Direction.LEFT)) {
            int newY = y - countSteps;
            if (newY >= 0) {
                coordinates[0] = x;
                coordinates[1] = newY;
            }
        }
        if (values[direction].equals(Direction.RIGHT)) {
            int newY = y + countSteps;
            if (newY < Settings.y) {
                coordinates[0] = x;
                coordinates[1] = newY;
            }
        }
        return coordinates;
    }

    // метод умирать
    public boolean die(Location location) {
        Integer percentageOfWeight = (Settings.weightUnit.get(this.getType()) * 75) / 100;
        if (this.getWeight() <= percentageOfWeight) {
            boolean remove = location.getUnitList().remove(this);
            // проверка
            //System.out.println(this.toString() + " скончалось от голода");
            return remove;
        }
        return false;
    }

    // мутод увеличивающий параметр сытости
    private void increaseSatiety(Unit unit) {
        Integer newWeight = this.getWeight() + unit.getWeight();
        if (newWeight < Settings.maxQuantityEatForSatiety.get(this.getType())) {
            this.setWeight(newWeight);
            // проверка
            //System.out.println(this.toString() + ":" + getWeight());
        } else {
            this.setWeight(Settings.maxQuantityEatForSatiety.get(this.getType()));
            // проверка
            //System.out.println(this.toString() + ":" + getWeight() + " ");
        }
    }

    // метод уменьшающий параметр сытости
    private void decreaseSatiety() {
        Integer newWeight = this.getWeight() - ((Settings.maxQuantityEatForSatiety.get(this.getType()) * 30) / 100);
        this.setWeight(newWeight);
        // проверка
        //System.out.print(this.toString() + ":" + getWeight() + " ");
    }
}
