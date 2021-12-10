package ua.univer.lesson12;

import java.io.Serializable;

public class Army implements Serializable {

    private String name;
    Droid[] droids;
    public Army(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
