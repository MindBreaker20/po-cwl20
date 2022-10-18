package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    @Test
    void testNext() {
        MapDirection d1 = MapDirection.NORTH; // Przypadek 1 - dla pólnocy kolejny kierunek to wschód zgodnie z ruchem wskazówek zegara
        assertEquals(MapDirection.EAST, d1.next());

        MapDirection d2 = MapDirection.EAST; // Przypadek 2 - dla wschodu kolejny kierunek to południe zgodnie z ruchem wskazówek zegara
        assertEquals(MapDirection.SOUTH, d2.next());

        MapDirection d3 = MapDirection.SOUTH; // Przypadek 3 - dla południa kolejny kierunek to zachód zgodnie z ruchem wskazówek zegara
        assertEquals(MapDirection.WEST, d3.next());

        MapDirection d4 = MapDirection.WEST;  // Przypadek 4 - dla zachodu kolejny kierunek to północ zgodnie z ruchem wskazówek zegara
        assertEquals(MapDirection.NORTH, d4.next());
    }

    @Test
    void testPrevious(){
        MapDirection d1 = MapDirection.NORTH; // Przypadek 1 - dla pólnocy wcześniejszy kierunek to zachód zgodnie z przeciwnym ruchem wskazówek zegara
        assertEquals(MapDirection.WEST, d1.previous());

        MapDirection d2 = MapDirection.EAST; // Przypadek 2 - dla wschodu wcześniejszy kierunek to północ zgodnie z przeciwnym ruchem wskazówek zegara
        assertEquals(MapDirection.NORTH, d2.previous());

        MapDirection d3 = MapDirection.SOUTH; // Przypadek 3 - dla południa wcześniejszy kierunek to wschód zgodnie z przeciwnym ruchem wskazówek zegara
        assertEquals(MapDirection.EAST, d3.previous());

        MapDirection d4 = MapDirection.WEST; // Przypadek 4 - dla zachodu wcześniejszy kierunek to południe zgodnie z przeciwnym ruchem wskazówek zegara
        assertEquals(MapDirection.SOUTH, d4.previous());
    }
}
