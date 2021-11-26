package ua.univer.lesson06;

public class BattleDroid extends Droid implements BattleDroidControllable {
    private double shootPower;
    private Blaster blaster;

    public static class Builder{
        private double damageLevel;
        private double energyLevel;
        private double shootPower;
        private Blaster blaster;

        public Builder(double damageLevel, double energyLevel) {
            this.damageLevel = damageLevel;
            this.energyLevel = energyLevel;
            this.shootPower = 10;
            this.blaster = new Blaster(1000);
        }
        public Builder shootPower(int shootPower){
            this.shootPower = shootPower;
            return this;
        }
        public Builder blaster(Blaster blaster){
            this.blaster = blaster;
            return this;
        }
        public BattleDroid build(){
            return new BattleDroid(damageLevel, energyLevel, shootPower, blaster);
        }
    }

    public static BattleDroid create(){
        return new BattleDroid(100,200,20);
    }

    private BattleDroid(double damageLevel, double energyLevel, double shootPower,Blaster blaster) {
        super(damageLevel, energyLevel);
        this.shootPower = shootPower;
        this.blaster = blaster;
    }

    public BattleDroid(double damageLevel, double energyLevel, double shootPower) {
        super(damageLevel, energyLevel);
        this.shootPower = shootPower;
        this.blaster = new Blaster(1000);
    }

    public double getShootPower() {
        return shootPower;
    }

    public void setShootPower(double shootPower) {
        this.shootPower = shootPower;
    }

    public Blaster getBlaster() {
        return blaster;
    }

    public void setBlaster(Blaster blaster) {
        this.blaster = blaster;
    }

    @Override
    public BattleDroid clone() throws CloneNotSupportedException {
        BattleDroid droid = (BattleDroid) super.clone();
        droid.setBlaster(this.getBlaster().clone());
        return droid;

    }


    void show() {

    }

    @Override
    public String toString() {
        return "BattleDroid{" +
                "shootPower=" + shootPower +
                ", blaster=" + blaster +
                "} " + super.toString();
    }
}
