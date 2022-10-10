package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        String[] str_input = {"f", "f", "r", "l"};
        Direction[] enum_input = string_to_enum(str_input);
        run(enum_input);
        System.out.println("system zakończył działanie");
    }
    public static Direction[] string_to_enum(String[] str_input) {
        Integer size = str_input.length;
        Direction[] enum_input = new Direction[size];//Enum na Direction
        for (int i = 0; i < size; ++i) {
            switch (str_input[i]) {
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
            }
        }
        return enum_input;
    }
    public static void run(Direction[] enum_input) {
        System.out.println("Start");

        for(int i = 0; i < enum_input.length; ++i){
            if(i < enum_input.length - 1){
                System.out.print(enum_input[i]);
                System.out.print(",");
            }
            else{
                System.out.print(enum_input[i]);
                System.out.print("\n");
            }
        }
        Integer size = enum_input.length;
        for (int j = 0; j < size; ++j) {
            if(enum_input[j] == Direction.f){
                System.out.println("Zwierzak idzie do przodu");
            }
            else if (enum_input[j] == Direction.b) {
                System.out.println("Zwierzak idzie do tyłu");
            }
            else if (enum_input[j] == Direction.r) {
                System.out.println("Zwierzak skręca w prawo");
            }
            else if (enum_input[j] == Direction.l) {
                System.out.println("Zwierzak skręca w lewo");
            }
        }
        System.out.println("Stop");
    }
}