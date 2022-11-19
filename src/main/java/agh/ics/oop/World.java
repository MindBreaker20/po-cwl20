package agh.ics.oop;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        args = "f b r l f f r r f f f f f f f f".split(" ");
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] initialPositions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, initialPositions);
        engine.run();
    }
}
