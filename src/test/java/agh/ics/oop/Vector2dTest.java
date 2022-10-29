package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test // Punkt 9 - testowanie orientacji zwierzęcia
    void testAnimalDirection(){
        Animal a1 = new Animal();
        assertEquals(a1.mapDirection, MapDirection.NORTH);
    }

    @Test // Punkt 9 - testowanie czy zwierzę przemieszcza się na właściwe pozycje
    void testRightVector(){
        Animal a1 = new Animal(); // Przypadek 1 - zwierze idzie w prawo
        MoveDirection m1 = MoveDirection.RIGHT;
        MoveDirection m2 = MoveDirection.FORWARD;
        Vector2d v1 = new Vector2d(3, 2);
        a1.move(m1);
        a1.move(m2);
        assertTrue(a1.isAt(v1));

        Animal a2 = new Animal(); // Przypadek 2 - zwierze idzie w lewo
        MoveDirection m3 = MoveDirection.LEFT;
        Vector2d v2 = new Vector2d(1, 2);
        a2.move(m3);
        a2.move(m2);
        assertTrue(a2.isAt(v2));

        Animal a3 = new Animal(); // Przypadek 3 - zwierze idzie do przodu
        MoveDirection m4 = MoveDirection.FORWARD;
        Vector2d v3 = new Vector2d(2, 3);
        a3.move(m4);
        assertTrue(a3.isAt(v3));

        Animal a4 = new Animal(); // Przypadek 4 - zwierze idzie do dołu/ do tyłu
        MoveDirection m5 = MoveDirection.BACKWARD;
        Vector2d v4 = new Vector2d(2, 1);
        a4.move(m5);
        assertTrue(a4.isAt(v4));
    }

    @Test // Punkt 9 - testowanie czy zwierzę nie wychodzi poza mapę
    void testOutOfMap(){
        Animal a1 = new Animal();
        MoveDirection m1 = MoveDirection.FORWARD;
        Vector2d v1 = new Vector2d(2, 4);
        a1.move(m1);
        a1.move(m1);
        a1.move(m1);
        assertTrue(a1.isAt(v1));
    }

    @Test // Punkt 9 - czy dane wejściowe podane jako tablica łańcuchów znaków są poprawnie interpretowane.
    void testArrayInterpretation(){
        Animal a1 = new Animal();
        Vector2d v1 = new Vector2d(3, 3);
        OptionsParser o1 = new OptionsParser();
        String[] string_array = new String[]{"f", "forward", "a", "backward", "c", "right", "d", "f"};
        MoveDirection[] move_direction_array = o1.parse(string_array);
        for(int j = 0; j< move_direction_array.length; j++){
            a1.move(move_direction_array[j]);
        }
        assertTrue(a1.isAt(v1));
    }

    @Test
    void testEquals(){
        Vector2d v1 = new Vector2d(1, 3); // Przypadek 1 - pozycje sa sobie rowne
        Vector2d v2 = new Vector2d(1, 3);
        assertTrue(v1.equals(v2));

        Vector2d v3 = new Vector2d(1, 3); // Przypadek 2 - pozycje nie sa rowne
        Vector2d v4 = new Vector2d(2, -1);
        assertFalse(v3.equals(v4));
    }

    @Test
    void testToString(){
        Vector2d v1 = new Vector2d(1, 3); // Przypadek 1 - czy stringi sa sobie rowne
        assertEquals(v1.toString(), "(1,3)");
    }

    @Test
    void testPrecedes(){
        Vector2d v1 = new Vector2d(1, 2); // Przypadek 1 -pola mają mniejszą wartość od pól drugiego obiektu
        Vector2d v2 = new Vector2d(3, 4);
        assertTrue(v1.precedes(v2));

        Vector2d v3 = new Vector2d(1, 2); // Przypadek 2 -pola mają równą wartość wzgledem pól drugiego obiektu
        Vector2d v4 = new Vector2d(1, 2);
        assertTrue(v3.precedes(v4));

        Vector2d v5 = new Vector2d(5, 8); // Przypadek 3 -pola mają większą wartość od pól drugiego obiektu
        Vector2d v6 = new Vector2d(3, 6);
        assertFalse(v5.precedes(v6));
    }

    @Test
    void testFollows(){
        Vector2d v1 = new Vector2d(5, 6); // Przypadek 1 -pola mają większą wartość od pól drugiego obiektu
        Vector2d v2 = new Vector2d(3, 4);
        assertTrue(v1.follows(v2));

        Vector2d v3 = new Vector2d(5, 6); // Przypadek 2 -pola mają równą wartość wzgledem pól drugiego obiektu
        Vector2d v4 = new Vector2d(5, 6);
        assertTrue(v3.follows(v4));

        Vector2d v5 = new Vector2d(5, 6); // Przypadek 3 -pola mają mniejszą wartość od pól drugiego obiektu
        Vector2d v6 = new Vector2d(8, 9);
        assertFalse(v5.follows(v6));
    }

    @Test
    void testUpperRight(){
        Vector2d v1 = new Vector2d(5, 6); // Przypadek 1 - składowe punktów mają rózne wartości i są porównywane z punktem o maksymalnych składowych
        Vector2d v2 = new Vector2d(3, 8);
        Vector2d v3 = new Vector2d(5, 8);
        assertEquals(v1.upperRight(v2), v3);
    }

    @Test
    void testLowerLeft(){
        Vector2d v1 = new Vector2d(5, 6); // Przypadek 1 - składowe punktów mają rózne wartości i są porównywane z punktem o minimalnych składowych
        Vector2d v2 = new Vector2d(3, 8);
        Vector2d v3 = new Vector2d(3, 6);
        assertEquals(v1.lowerLeft(v2), v3);
    }

    @Test
    void testAdd(){
        Vector2d v1 = new Vector2d(5, 6); // Przypadek 1 - składowe punktów mają różne wartosci i są porównywane z punktem,którego składowe są sumę dwóch pkt
        Vector2d v2 = new Vector2d(3, 8);
        Vector2d v3 = new Vector2d(8, 14);
        assertEquals(v1.add(v2), v3);
    }

    @Test
    void testSubtract(){
        Vector2d v1 = new Vector2d(5, 6); // Przypadek 1 - składowe punktów mają różne wartosci i są porównywane z punktem,którego składowe są różnicą dwóch pkt
        Vector2d v2 = new Vector2d(3, 8);
        Vector2d v3 = new Vector2d(2, -2);
        assertEquals(v1.subtract(v2), v3);
    }

    @Test
    void testOpposite(){
        Vector2d v1 = new Vector2d(5, 6); // Przypadek 1 - następuje zamiana składowych punktu i przyrównanie go do wzorca
        Vector2d v2 = new Vector2d(-5, -6);
        assertEquals(v1.opposite(), v2);
    }
}
