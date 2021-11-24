package ua.univer.lesson05;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p0 = new Point();
        Pointlist pointlist = new Pointlist(3);
        pointlist.add(p0);
        pointlist.add(p1);
        pointlist.add(new Point(3,3));

        System.out.println(pointlist);

    }
}
