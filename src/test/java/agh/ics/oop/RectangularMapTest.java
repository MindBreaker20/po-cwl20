package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void testCanMoveTo(){
        RectangularMap map = new RectangularMap(10, 5);
        map.place(new Animal(map, new Vector2d(2, 3)));
        assertFalse(map.canMoveTo(new Vector2d(2, 3)));
        assertFalse(map.canMoveTo(new Vector2d(-10,-5)));
    }

    @Test
    public void testPlace(){
        RectangularMap map = new RectangularMap(10, 5);
        assertTrue(map.place(new Animal(map, new Vector2d(2, 3))));
        //assertFalse(map.place(new Animal(map, new Vector2d(2, 3))));
        assertThrows(IllegalArgumentException.class, () -> map.place(new Animal(map, new Vector2d(2, 3)))); // Od lab 7
    }

    @Test
    public void testIsOccupied(){
        RectangularMap map = new RectangularMap(10, 5);
        assertTrue(map.place(new Animal(map, new Vector2d(2, 3))));
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
        assertFalse(map.isOccupied(new Vector2d(3, 2)));
    }

    @Test
    public void testObjectAt(){
        RectangularMap map = new RectangularMap(10, 5);
        assertEquals(map.objectAt(new Vector2d(2, 3)), map.objectAt(new Vector2d(2,3)));
    }
}
