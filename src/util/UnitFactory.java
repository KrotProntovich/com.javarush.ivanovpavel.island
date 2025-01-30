package util;

import configuration.Settings;
import entity.unit.Unit;
import entity.unit.animal.herbivore.*;
import entity.unit.animal.predator.*;
import entity.unit.plant.Plant;

public class UnitFactory {
    private long countBornWolf = 0;
    private long countBornBoa = 0;
    private long countBornFox = 0;
    private long countBornBear = 0;
    private long countBornEagle = 0;
    private long countBornHorse = 0;
    private long countBornDeer = 0;
    private long countBornRabbit = 0;
    private long countBornMouse = 0;
    private long countBornGoat = 0;
    private long countBornSheep = 0;
    private long countBornBoar = 0;
    private long countBornBuffalo = 0;
    private long countBornDuck = 0;
    private long countBornCaterpillar = 0;
    private long countBornPlant = 0;

    public Unit createAnimal(UnitType unitType) {
        return switch (unitType) {
            case WOLF -> {
                countBornWolf++;
                yield  new Wolf(countBornWolf, UnitType.WOLF, Settings.weightUnit.get(UnitType.WOLF), false);
            }
            case BOA -> {
                countBornBoa++;
                yield  new Boa(countBornBoa, UnitType.BOA, Settings.weightUnit.get(UnitType.BOA),false);
            }
            case FOX -> {
                countBornFox++;
                yield  new Fox(countBornFox, UnitType.FOX, Settings.weightUnit.get(UnitType.FOX),false);
            }
            case BEAR -> {
                countBornBear++;
                yield  new Bear(countBornBear, UnitType.BEAR, Settings.weightUnit.get(UnitType.BEAR),false);
            }
            case EAGLE -> {
                countBornEagle++;
            yield new Eagle(countBornEagle, UnitType.EAGLE, Settings.weightUnit.get(UnitType.EAGLE), false);
            }
            case HORSE -> {
                countBornHorse++;
                yield  new Horse(countBornHorse, UnitType.HORSE, Settings.weightUnit.get(UnitType.HORSE), false);
            }
            case DEER -> {
                countBornDeer++;
                yield new Deer(countBornDeer, UnitType.DEER, Settings.weightUnit.get(UnitType.DEER), false);
            }
            case RABBIT -> {
                countBornRabbit++;
                yield new Rabbit(countBornRabbit, UnitType.RABBIT,  Settings.weightUnit.get(UnitType.RABBIT), false);
            }
            case MOUSE -> {
                countBornMouse++;
            yield new Mouse(countBornMouse, UnitType.MOUSE, Settings.weightUnit.get(UnitType.MOUSE), false);
            }
            case GOAT -> {
                countBornGoat++;
                yield new Goat(countBornGoat, UnitType.GOAT, Settings.weightUnit.get(UnitType.GOAT), false);
            }
            case SHEEP -> {
                countBornSheep++;
                yield new Sheep(countBornSheep, UnitType.SHEEP, Settings.weightUnit.get(UnitType.SHEEP), false);
            }
            case BOAR -> {
                countBornBoar++;
                yield new Boar(countBornBoar, UnitType.BOAR, Settings.weightUnit.get(UnitType.BOAR), false);
            }
            case BUFFALO -> {
                countBornBuffalo++;
                yield new Buffalo(countBornBuffalo, UnitType.BUFFALO, Settings.weightUnit.get(UnitType.BUFFALO), false);
            }
            case DUCK -> {
                countBornDuck++;
                yield new Duck(countBornDuck, UnitType.DUCK, Settings.weightUnit.get(UnitType.DUCK), false);
            }
            case CATERPILLAR -> {
                countBornCaterpillar++;
                yield new Caterpillar(countBornCaterpillar, UnitType.CATERPILLAR,  Settings.weightUnit.get(UnitType.CATERPILLAR), false);
            }
            case PLANT -> {
                countBornPlant++;
                yield new Plant(countBornPlant, UnitType.PLANT,Settings.weightUnit.get(UnitType.PLANT), false);
            }
        };
    }

}
