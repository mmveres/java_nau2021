package ua.advanced.lesson03;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
class Ship{
    private String name;
    private int x;
    private int y;

    public Ship(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return  name.equals(ship.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", hash ="+hashCode()+
                '}';
    }
}
public class Program {
    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<>();
        map.put(1,"A");
        map.put(8,"B");
        map.put(18,"C");
        map.put(16,"D");
        map.put(32,"F");
        System.out.println(map);
        Map<Integer,String> syncMap = Collections.synchronizedMap(map);
        ConcurrentHashMap chm;

        Set<Ship> ships = new HashSet<>();
        ships.add(new Ship("AAA", 1,2));
        ships.add(new Ship("AAA", 1,3));
        ships.add(new Ship("BBB", 1,2));
        System.out.println(ships);

        System.out.println(ships.contains(new Ship("AAA",5,6)));

        Map<String, Integer> freqMap = new HashMap<>();
        String str = "mama mila ramu ramu mala ramu";
        for (var word: str.split(" ")) {
            if (!freqMap.containsKey(word))
                freqMap.put(word, 1);
            else
                freqMap.put(word, freqMap.get(word)+1);
        }
        System.out.println(freqMap);
    }
}
