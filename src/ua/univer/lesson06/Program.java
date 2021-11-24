package ua.univer.lesson06;

public class Program {

    public static void printControllable(BattleDroidControllable controllable){
        System.out.println(controllable.getShootPower());
    }

    public static void printDamage(Droid d){
        System.out.println(d.getDamageLevel());
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Droid d1 = new Droid(50, 50);
        Droid d2 = new Droid(d1);
        d2.setEnergyLevel(70);
        System.out.println(d1);
        System.out.println(d2);

        Droid d3 = d1.clone();
        d3.setDamageLevel(80);
        System.out.println(d3);

        //     Object obj = new Object();
        //      Object obj1 = obj.clone();

        BattleDroid bd1 = new BattleDroid(200, 250, 20);
        BattleDroid bd2 = bd1.clone();

        bd2.setEnergyLevel(77);
        bd2.setShootPower(7);
        bd2.getBlaster().setAmmo(777);


        System.out.println(bd1);
        System.out.println(bd2);

        BattleDroid bd3 = BattleDroid.create();

        BattleDroid bd4 = new BattleDroid
                .Builder(55, 66)
                .blaster(new Blaster(500))
                .build();

        System.out.println(bd4);

        printControllable(bd1);

        Droid [] droids = {d1, bd1};

        printDamage(d1);
        printDamage(bd1);

    }
}
