package ua.univer.lesson05;

import java.util.Arrays;

public class Pointlist {
    private Point [] points;
    private int ilast;

    public Pointlist(Point[] points) {
        this.points = points;
        ilast = points.length-1;
    }

    public Pointlist(int n) {
        this.points = new Point[n];
        ilast = -1;
    }

    public void add(Point p){
        if (ilast == points.length-1)
            this.points = Arrays.copyOf(this.points, this.points.length*2);
        this.points[++ilast] = p;
    }

    @Override
    public String toString() {
        return "Pointlist{" +
                "points=" + Arrays.toString(points) +
                ", ilast=" + ilast +
                '}';
    }
}
