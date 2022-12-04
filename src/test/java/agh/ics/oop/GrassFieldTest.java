package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void testCanMoveTo(){
        GrassField map = new GrassField(5);
        map.place(new Animal(map, new Vector2d(2, 3)));
        assertFalse(map.canMoveTo(new Vector2d(2, 3)));
        assertFalse(map.canMoveTo(new Vector2d(-10,-5)));
        assertTrue(map.canMoveTo(new Vector2d(1000, 1000)));
    }

    @Test
    public void testPlace(){
        GrassField map = new GrassField(5);
        map.place(new Animal(map, new Vector2d(2, 3)));
        assertThrows(IllegalArgumentException.class, () -> map.place(new Animal(map, new Vector2d(2, 3))));
    }

    @Test
    public void testIsOccupied(){
        GrassField map = new GrassField(5);
        assertTrue(map.place(new Animal(map, new Vector2d(2, 3))));
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
        assertFalse(map.isOccupied(new Vector2d(3, 2)));
    }

    @Test
    public void testObjectAt(){
        GrassField map = new GrassField(5);
        assertEquals(map.objectAt(new Vector2d(2, 3)), map.objectAt(new Vector2d(2,3)));
    }
}
