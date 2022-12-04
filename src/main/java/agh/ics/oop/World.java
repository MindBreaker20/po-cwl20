package agh.ics.oop;

import static java.lang.System.out;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class World {

    public static void main(String[] args) {
//        try{
//            args = "a f b r l f f r r f f f f f f f f".split(" ");
//            MoveDirection[] directions = new OptionsParser().parse(args);
//            IWorldMap map = new GrassField(10);
//            Vector2d[] positions = { new Vector2d(3,4), new Vector2d(3,4) };
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//
//        }catch(IllegalArgumentException expn){
//            out.println(expn.getMessage());
//        }
         // a is not legal move specification
         // Animal cannot be placed on (3,4)

        Application.launch(App.class, args);
    }
}

