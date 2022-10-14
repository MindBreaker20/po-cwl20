package agh.ics.oop;
import static java.lang.System.out;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        out.println("system wystartował");
        Scanner scr = new Scanner(System.in); // Wprowadzenie sekwencji liter oddzielonych spacjami
        String[] sequence;

        while(true){
            sequence = scr.nextLine().split(" ");
            if(sequence.length >= 2){ // Kontrola długości sekwencji min. 2 parametry
                break;
            }
            else{
                out.println(("liczba parametrów musi wynosić co najmniej 2!"));
            }
        }

        Direction[] sequence2 = string_to_enum(sequence); // Zamiana tablicy znaków na tablicę wartości typu wyliczeniowego
        run(sequence2, sequence); /* Funckja przjmuje dwa argumenty, przy czym jako druga podawana jest tablica znaków potrzebna
                                   do wydrukowania wartości parametrów spoza enum*/
        out.println("system zakończył działanie");
    }

    public static Direction[] string_to_enum(String[] input) {
        Integer size = input.length;
        Direction[] enum_input = new Direction[size];
        for (int i = 0; i < size; ++i) {
            switch (input[i]) {
                case "f":
                    enum_input[i] = Direction.f;
                    break;
                case "b":
                    enum_input[i] = Direction.b;
                    break;
                case "r":
                    enum_input[i] = Direction.r;
                    break;
                case "l":
                    enum_input[i] = Direction.l;
                    break;
                default:
                    enum_input[i] = Direction.o; // Wszystkie parametry nie reprezentujące kierunku sa klasyfikowane w enum jako inne (other)
            }
        }
        return enum_input;
    }
    public static void run(Direction[] input, String[] input2){
        out.println("zwierzak idzie do przodu");
        for(int i = 0; i < input.length; ++i){
            if(input[i].equals(Direction.o)){ /* W pierwszej kolejności badane jest czy parametr reprezentuje kierunek czy też nie.
                                              Ma to na celu ochronę wartości takich parametrów przed zastępieniem ich znakiem 'o' z enum*/
                if(i < input2.length - 1){
                    System.out.print(input2[i]);
                    System.out.print(",");
                }
                else{
                    System.out.print(input2[i]); // Dla ostatniego parametru program nie pisze po nim przecinka
                    System.out.print("\n");
                }
            }
            else {
                if(i < input.length - 1){
                    System.out.print(input[i]);
                    System.out.print(",");
                }
                else{
                    System.out.print(input[i]);
                    System.out.print("\n");
                }
            }
        }
        out.println("Start");
        for (int j = 0; j < input.length; ++j) {
            switch (input[j]) {
                case f:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case b:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case r:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case l:
                    out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
        out.println("Stop");
    }
}
