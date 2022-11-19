package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalIntegrationTest {
    @Test // Punkt 7 - testowanie poprawnosci implementacji mapy
    public void testMap(){
        MoveDirection[] directions = new OptionsParser().parse("f b r l f f r r f f f f f f f f".split(" "));
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] initialPositions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, initialPositions);
        engine.run();
        assertTrue(engine.getAnimal(0).isAt(new Vector2d(2, 2)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(3, 4)));
    }

    @Test // Punkt 9 - testowanie orientacji zwierzęcia
    public void testOrientation(){
        Animal a1 = new Animal();
        assertEquals(a1.getDirection(), MapDirection.NORTH);
        a1.move(MoveDirection.LEFT);
        assertEquals(a1.getDirection(), MapDirection.WEST);
        a1.move(MoveDirection.RIGHT);
        assertEquals(a1.getDirection(),MapDirection.NORTH);
        a1.move(MoveDirection.RIGHT);
        assertEquals(a1.getDirection(), MapDirection.EAST);
        a1.move(MoveDirection.RIGHT);
        assertEquals(a1.getDirection(), MapDirection.SOUTH);
    }

    @Test // Punkt 9 - testowanie czy zwierzę przemieszcza się na właściwe pozycje i czy nie ywchodzi poza mape
    public void testPosition(){
        Animal a1 = new Animal();
        assertTrue(a1.isAt(new Vector2d(2,2)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(2,3)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(2,4)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(2,4))); // Sprawdzanie czy nie przekracza górnej granicy mapy
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(1,4)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(0,4)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(0,4))); // Sprawdzanie czy nie przekracza lewej grnicy mapy
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(0,3)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(0,2)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(0,1)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(0,0)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(0,0))); // Sprawdzanie czy nie przekracza dolnej granicy mapy
        a1.move(MoveDirection.LEFT);
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(1,0)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(2,0)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(3,0)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(4,0)));
        a1.move(MoveDirection.FORWARD);
        assertTrue(a1.isAt(new Vector2d(4,0))); // Sprawdzanie czy nie przekracza prawej granicy mapy
    }

    @Test // Punkt 9 - czy dane wejściowe podane jako tablica łańcuchów znaków są poprawnie interpretowane.
    void testParser(){
        Animal a1 = new Animal();
        OptionsParser o1 = new OptionsParser();
        String[] string_array = new String[]{"f", "forward", "a", "backward", "c", "right", "d", "f"};
        MoveDirection[] move_direction_array = o1.parse(string_array);
        for(int j = 0; j< move_direction_array.length; j++){
            a1.move(move_direction_array[j]);
        }
        assertTrue(a1.isAt(new Vector2d(3,3)));
    }
}
