package ua.univer.lesson06;

public class Blaster implements Cloneable {
    private int ammo;

    public Blaster(int ammo) {
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    @Override
    protected Blaster clone() throws CloneNotSupportedException {
        return (Blaster) super.clone();
    }

    @Override
    public String toString() {
        return "Blaster{" +
                "ammo=" + ammo +
                '}';
    }
}
