package configuration;

import util.UnitType;

import java.util.HashMap;

public class Settings {

    public static int x = 100;// размер острова горизоталь
    public static int y = 20;// размер острова вертикаль
    public static int day = 200;// продолжительность симуляции в днях

    public static int predator = 5;// начальное количество хищников каждого вида для каждой локации
    public static int herbivorous = 10;// начальне количество травоядных каждого вида для каждой локации
    public static int plants = 10;// начальное количество растений каждого вида для каждой локации

    public static HashMap<UnitType, Integer> maxCountUnit;// макимальное количество сущностей одного вида на локации
    public static HashMap<UnitType, Integer> countChildrenAnimal;// количество детеныщей
    public static HashMap<UnitType, Integer> maxCountStepsAnimal;// максимальное количество ходов
    public static HashMap<UnitType, Integer> maxQuantityEatForSatiety;// количество г пищи для полного насыщения
    public static HashMap<UnitType, Integer> weightUnit;// вес г сущности

    // таблица вероятности поедания
    public static HashMap<Integer, UnitType> eatWolfStatistic;
    public static HashMap<Integer, UnitType> eatBoaStatistic;
    public static HashMap<Integer, UnitType> eatFoxStatistic;
    public static HashMap<Integer, UnitType> eatBearStatistic;
    public static HashMap<Integer, UnitType> eatEagleStatistic;
    public static HashMap<Integer, UnitType> eatHorseStatistic;
    public static HashMap<Integer, UnitType> eatDeerStatistic;
    public static HashMap<Integer, UnitType> eatRabbitStatistic;
    public static HashMap<Integer, UnitType> eatMouseStatistic;
    public static HashMap<Integer, UnitType> eatGoatStatistic;
    public static HashMap<Integer, UnitType> eatSheepStatistic;
    public static HashMap<Integer, UnitType> eatBoarStatistic;
    public static HashMap<Integer, UnitType> eatBuffaloStatistic;
    public static HashMap<Integer, UnitType> eatDuckStatistic;
    public static HashMap<Integer, UnitType> eatCaterpillarStatistic;


    static {
        maxCountUnit = new HashMap<>();
        maxCountUnit.put(UnitType.WOLF, 30);
        maxCountUnit.put(UnitType.BOA, 30);
        maxCountUnit.put(UnitType.FOX, 30);
        maxCountUnit.put(UnitType.BEAR, 5);
        maxCountUnit.put(UnitType.EAGLE, 20);
        maxCountUnit.put(UnitType.HORSE, 20);
        maxCountUnit.put(UnitType.DEER, 20);
        maxCountUnit.put(UnitType.RABBIT, 150);
        maxCountUnit.put(UnitType.MOUSE, 500);
        maxCountUnit.put(UnitType.GOAT, 140);
        maxCountUnit.put(UnitType.SHEEP, 140);
        maxCountUnit.put(UnitType.BOAR, 50);
        maxCountUnit.put(UnitType.BUFFALO, 10);
        maxCountUnit.put(UnitType.DUCK, 200);
        maxCountUnit.put(UnitType.CATERPILLAR, 1000);
        maxCountUnit.put(UnitType.PLANT, 200);
    }

    static {
        countChildrenAnimal = new HashMap<>();
        countChildrenAnimal.put(UnitType.WOLF, 1);
        countChildrenAnimal.put(UnitType.BOA, 1);
        countChildrenAnimal.put(UnitType.FOX, 1);
        countChildrenAnimal.put(UnitType.BEAR, 1);
        countChildrenAnimal.put(UnitType.EAGLE, 1);
        countChildrenAnimal.put(UnitType.HORSE, 1);
        countChildrenAnimal.put(UnitType.DEER, 1);
        countChildrenAnimal.put(UnitType.RABBIT, 1);
        countChildrenAnimal.put(UnitType.MOUSE, 1);
        countChildrenAnimal.put(UnitType.GOAT, 1);
        countChildrenAnimal.put(UnitType.SHEEP, 1);
        countChildrenAnimal.put(UnitType.BOAR, 1);
        countChildrenAnimal.put(UnitType.BUFFALO, 1);
        countChildrenAnimal.put(UnitType.DUCK, 1);
        countChildrenAnimal.put(UnitType.CATERPILLAR, 1);
    }

    static {
        maxCountStepsAnimal = new HashMap<>();
        maxCountStepsAnimal.put(UnitType.WOLF, 3);
        maxCountStepsAnimal.put(UnitType.BOA, 1);
        maxCountStepsAnimal.put(UnitType.FOX, 2);
        maxCountStepsAnimal.put(UnitType.BEAR, 2);
        maxCountStepsAnimal.put(UnitType.EAGLE, 3);
        maxCountStepsAnimal.put(UnitType.HORSE, 4);
        maxCountStepsAnimal.put(UnitType.DEER, 4);
        maxCountStepsAnimal.put(UnitType.RABBIT, 2);
        maxCountStepsAnimal.put(UnitType.MOUSE, 1);
        maxCountStepsAnimal.put(UnitType.GOAT, 3);
        maxCountStepsAnimal.put(UnitType.SHEEP, 3);
        maxCountStepsAnimal.put(UnitType.BOAR, 2);
        maxCountStepsAnimal.put(UnitType.BUFFALO, 3);
        maxCountStepsAnimal.put(UnitType.DUCK, 4);
        maxCountStepsAnimal.put(UnitType.CATERPILLAR, 0);
    }

    static {
        maxQuantityEatForSatiety = new HashMap<>();
        maxQuantityEatForSatiety.put(UnitType.WOLF, 8000);
        maxQuantityEatForSatiety.put(UnitType.BOA, 3000);
        maxQuantityEatForSatiety.put(UnitType.FOX, 2000);
        maxQuantityEatForSatiety.put(UnitType.BEAR, 80000);
        maxQuantityEatForSatiety.put(UnitType.EAGLE, 1000);
        maxQuantityEatForSatiety.put(UnitType.HORSE, 60000);
        maxQuantityEatForSatiety.put(UnitType.DEER, 50000);
        maxQuantityEatForSatiety.put(UnitType.RABBIT, 450);
        maxQuantityEatForSatiety.put(UnitType.MOUSE, 10);
        maxQuantityEatForSatiety.put(UnitType.GOAT, 10000);
        maxQuantityEatForSatiety.put(UnitType.SHEEP, 15000);
        maxQuantityEatForSatiety.put(UnitType.BOAR, 50000);
        maxQuantityEatForSatiety.put(UnitType.BUFFALO, 100000);
        maxQuantityEatForSatiety.put(UnitType.DUCK, 150);
        maxQuantityEatForSatiety.put(UnitType.CATERPILLAR, 0);
    }

    static {
        eatWolfStatistic = new HashMap<>();
        eatWolfStatistic.put(10, UnitType.HORSE);
        eatWolfStatistic.put(15, UnitType.DEER);
        eatWolfStatistic.put(60, UnitType.RABBIT);
        eatWolfStatistic.put(80, UnitType.MOUSE);
        eatWolfStatistic.put(60, UnitType.GOAT);
        eatWolfStatistic.put(70, UnitType.SHEEP);
        eatWolfStatistic.put(15, UnitType.BOAR);
        eatWolfStatistic.put(10, UnitType.BUFFALO);
        eatWolfStatistic.put(40, UnitType.BUFFALO);


    }

    static {
        eatBoaStatistic = new HashMap<>();
        eatBoaStatistic.put(15, UnitType.FOX);
        eatBoaStatistic.put(20, UnitType.RABBIT);
        eatBoaStatistic.put(40, UnitType.MOUSE);
        eatBoaStatistic.put(10, UnitType.DUCK);
    }

    static {
        eatFoxStatistic = new HashMap<>();
        eatFoxStatistic.put(70, UnitType.RABBIT);
        eatFoxStatistic.put(90, UnitType.MOUSE);
        eatFoxStatistic.put(60, UnitType.DUCK);
        eatFoxStatistic.put(40, UnitType.CATERPILLAR);
    }

    static {
        eatBearStatistic = new HashMap<>();
        eatBearStatistic.put(80, UnitType.BOA);
        eatBearStatistic.put(40, UnitType.HORSE);
        eatBearStatistic.put(80, UnitType.DEER);
        eatBearStatistic.put(80, UnitType.RABBIT);
        eatBearStatistic.put(90, UnitType.MOUSE);
        eatBearStatistic.put(70, UnitType.GOAT);
        eatBearStatistic.put(70, UnitType.SHEEP);
        eatBearStatistic.put(50, UnitType.BOAR);
        eatBearStatistic.put(20, UnitType.BUFFALO);
        eatBearStatistic.put(10, UnitType.DUCK);
    }

    static {
        eatEagleStatistic = new HashMap<>();
        eatEagleStatistic.put(10, UnitType.FOX);
        eatEagleStatistic.put(90, UnitType.RABBIT);
        eatEagleStatistic.put(90, UnitType.MOUSE);
        eatEagleStatistic.put(80, UnitType.DUCK);
    }

    static {
        eatHorseStatistic = new HashMap<>();
        eatHorseStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatDeerStatistic = new HashMap<>();
        eatDeerStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatRabbitStatistic = new HashMap<>();
        eatRabbitStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatMouseStatistic = new HashMap<>();
        eatMouseStatistic.put(90, UnitType.CATERPILLAR);
        eatMouseStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatGoatStatistic = new HashMap<>();
        eatGoatStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatSheepStatistic = new HashMap<>();
        eatSheepStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatBoarStatistic = new HashMap<>();
        eatBoarStatistic.put(50, UnitType.MOUSE);
        eatBoarStatistic.put(90, UnitType.CATERPILLAR);
        eatBoarStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatBuffaloStatistic = new HashMap<>();
        eatBuffaloStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatDuckStatistic = new HashMap<>();
        eatDuckStatistic.put(90, UnitType.CATERPILLAR);
        eatDuckStatistic.put(100, UnitType.PLANT);
    }

    static {
        eatCaterpillarStatistic = new HashMap<>();
        eatCaterpillarStatistic.put(100, UnitType.PLANT);
    }

    static {
        weightUnit = new HashMap<>();
        weightUnit.put(UnitType.WOLF, 50000);
        weightUnit.put(UnitType.BOA, 15000);
        weightUnit.put(UnitType.FOX, 8000);
        weightUnit.put(UnitType.BEAR, 500000);
        weightUnit.put(UnitType.EAGLE, 6000);
        weightUnit.put(UnitType.HORSE, 400000);
        weightUnit.put(UnitType.DEER, 300000);
        weightUnit.put(UnitType.RABBIT, 2000);
        weightUnit.put(UnitType.MOUSE, 50);
        weightUnit.put(UnitType.GOAT, 60000);
        weightUnit.put(UnitType.SHEEP, 70000);
        weightUnit.put(UnitType.BOAR, 400000);
        weightUnit.put(UnitType.BUFFALO, 700000);
        weightUnit.put(UnitType.DUCK, 1000);
        weightUnit.put(UnitType.CATERPILLAR, 10);
        weightUnit.put(UnitType.PLANT, 1000);
    }
}
