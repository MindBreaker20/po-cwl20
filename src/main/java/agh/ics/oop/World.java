package agh.ics.oop;
import static java.lang.System.out;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        // Punkt 2 i 3
        System.out.println(a1.toString());
        Vector2d v1 = new Vector2d(2, 2);
        System.out.println(a1.isAt(v1));
        // Punkt 5
        MoveDirection m1 = MoveDirection.RIGHT;
        a1.move(m1);
        MoveDirection m2 = MoveDirection.FORWARD;
        a1.move(m2);
        a1.move(m2);
        a1.move(m2);
        System.out.println(a1.toString());
        // Punkt 7 i 8
        Animal a2 = new Animal();
        System.out.println(a2.toString());
        OptionsParser o1 = new OptionsParser();
        String[] string_array = new String[]{"f", "forward", "a", "backward", "b", "c", "right", "r", "d", "left","l"};
        MoveDirection[] move_direction_array = o1.parse(string_array);
        for(int j = 0; j< move_direction_array.length; j++){
            a2.move(move_direction_array[j]);
            System.out.println(a2.toString());
        }
        // Punkt 10
        /* Mechanizm wykluczający pojawienie się dwóch zwierząt w tym samym miejscu powinien wykorzystywać metodę isAt w klasie Animal. Byłaby ona wywolywana
           W metodzie move klasy Animal. W przypadku odczytu kierunku sprawdzany byłby warunek czy zwierze znalazloby sie w tym samym miejscu co drugie zwierze
            za pomocą wspomnianej metody isAt oraz Vector2d zwierzecia. Gdyby w warunku wyszło, że true równa się true to ruch nie byłby wykonywany.*/
    }
}
