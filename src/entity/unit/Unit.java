package entity.unit;

import util.UnitType;

public abstract class Unit {
    private long id;
    private UnitType type;
    private Integer weight;
    private boolean eaten;// флаг обозначающий съеден


    public Unit(long id, UnitType type, Integer weight, boolean eaten) {
        this.id = id;
        this.type = type;
        this.weight = weight;
        this.eaten = eaten;
    }

    public long getId() {
        return id;
    }

    public UnitType getType() {
        return type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + getId();
    }

}
