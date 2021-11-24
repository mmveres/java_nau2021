package ua.univer.lesson05;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException();

        this.x = x;
        this.y = y;
    }

    public Point(int x) {
        this(x, 1);
    }

    public Point (){
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
