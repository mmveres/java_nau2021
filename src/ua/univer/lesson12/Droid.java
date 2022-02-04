package ua.univer.lesson12;

import java.io.Serializable;
import java.util.Arrays;

public class Droid implements Serializable {
    private String name;
    private int armorAmount;
    private int weaponsAmount;
    private static Army army;
    private transient String[] weapons;
    private int countWeapon;

    public Droid() {
//stuff to do
    }

    public Droid(String name, int armorAmount, int weaponsAmount, Army army) {
        this.name = name;
        this.armorAmount = armorAmount;
        this.weaponsAmount = weaponsAmount;
        this.army = army;
        this.weapons = new String[10];
        this.countWeapon = 0;
    }

    public String getName() {
        return name;
    }

    public int getArmorAmount() {
        return armorAmount;
    }

    public void setArmorAmount(int armorAmount) {
        this.armorAmount = armorAmount;
    }

    public int getWeaponsAmount() {
        return weaponsAmount;
    }

    public void setWeaponsAmount(int weaponsAmount) {
        this.weaponsAmount = weaponsAmount;
    }

    public static Army getArmy() {
        return army;
    }

    public static void setArmy(Army army) {
        Droid.army = army;
    }

    public String[] getWeapons() {
        return weapons;
    }

    public void addWeapons(String weapon) {
        this.weapons[countWeapon++] = weapon;
    }



    public String toTxt(String delimetr) {
        StringBuilder sb = new StringBuilder();
        for (var weapon : weapons) {
            if (weapon == null) break;
            sb.append(weapon + delimetr);
        }

        return name + delimetr + armorAmount +
                delimetr + weaponsAmount +
                delimetr + army +
                delimetr + countWeapon + delimetr +
                sb.toString();
    }

    @Override
    public String toString() {
        return "\nDroid{" +
                "name='" + name + '\'' +
                ", armorAmount=" + armorAmount +
                ", weaponsAmount=" + weaponsAmount +
                ", army=" + army +
                ", weapons=" + Arrays.toString(weapons) +
                ", countWeapon=" + countWeapon +
                '}';
    }
}