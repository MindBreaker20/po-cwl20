package agh.ics.oop;
import static java.lang.System.out;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection d1 = MapDirection.NORTH;
        System.out.println(d1);
        System.out.println(d1.next());
        System.out.println(d1.previous());
        System.out.println(d1.toUnitVector());
    }
}
