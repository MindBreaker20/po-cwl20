package agh.ics.oop;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {
    @Test
    public void testMap(){
        MoveDirection[] directions = new OptionsParser().parse(Arrays.asList("f b r l f f r r f f f f f f f f".split(" ")));
        IWorldMap map = new RectangularMap(10, 5);
        List<Vector2d> initialPositions = Arrays.asList(new Vector2d(2,2), new Vector2d(3,4));
        SimulationEngine engine = new SimulationEngine(directions, map, initialPositions);
        engine.run();

        assertEquals(engine.getAnimal(0).getPosition(), new Vector2d(2, 0));
        assertEquals(engine.getAnimal(1).getPosition(), new Vector2d(3, 4));
    }
}
