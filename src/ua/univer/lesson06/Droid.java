package ua.univer.lesson06;

public  class Droid implements Cloneable {
    private double damageLevel;
    private double energyLevel;

    public Droid(Droid droid) {
        this(droid.getDamageLevel(), droid.getEnergyLevel());
    }

    public Droid(double damageLevel, double energyLevel) {
        super();
        setDamageLevel(damageLevel);
        this.energyLevel = energyLevel;
    }
    public Droid(double damageLevel) {
        this(damageLevel,100);
    }
    public Droid() {
        this(100);
    }

    @Override
    public Droid clone() throws CloneNotSupportedException {
        return (Droid) super.clone();
    }

    public double getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(double damageLevel) {
        if (damageLevel < 0)
            throw new IllegalArgumentException();
        this.damageLevel = damageLevel;
    }

    public double getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(double energyLevel) {
        this.energyLevel = energyLevel;
    }

    //  abstract void show();
    @Override
    public String toString() {
        return "Droid{" +
                "damageLevel=" + damageLevel +
                ", energyLevel=" + energyLevel +
                '}';
    }
}
