package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest { // Lab 3 - testy integracyjne
    @Test // Lab3 - Punkt 9 - testowanie orientacji zwierzęcia
    public void testOrientation(){
        // Animal a1 = new Animal();// Od lab4 używa canMoveTo IWorldMap dlatego tu już nie bedzie dizalac
        Animal a1 = new Animal(new RectangularMap(5, 5)); // Od lab 5
        assertEquals(a1.getMapDirection(), MapDirection.NORTH);
        a1.move(MoveDirection.LEFT);
        assertEquals(a1.getMapDirection(), MapDirection.WEST);
        a1.move(MoveDirection.RIGHT);
        assertEquals(a1.getMapDirection(),MapDirection.NORTH);
        a1.move(MoveDirection.RIGHT);
        assertEquals(a1.getMapDirection(), MapDirection.EAST);
        a1.move(MoveDirection.RIGHT);
        assertEquals(a1.getMapDirection(), MapDirection.SOUTH);
    }

    @Test // Lab3 - Punkt 9 - testowanie czy zwierzę przemieszcza się na właściwe pozycje i czy nie ywchodzi poza mape
    public void testPosition(){
        //Animal a1 = new Animal();
        Animal a1 = new Animal(new RectangularMap(5, 5)); // Od lab 5
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

    @Test // Lab3 - Punkt 9 - czy dane wejściowe podane jako tablica łańcuchów znaków są poprawnie interpretowane.
    void testParser(){
        //Animal a1 = new Animal();
        Animal a1 = new Animal(new RectangularMap(5, 5)); // Od lab 5
        OptionsParser o1 = new OptionsParser();
        String[] string_array = new String[]{"f", "forward", "a", "backward", "c", "right", "d", "f"};
        MoveDirection[] move_direction_array = o1.parse(string_array);
        for(int j = 0; j< move_direction_array.length; j++){
            a1.move(move_direction_array[j]);
        }
        assertTrue(a1.isAt(new Vector2d(3,3)));
    }
}
