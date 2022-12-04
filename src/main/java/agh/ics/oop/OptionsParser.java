package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(List<String> args) {
        List<MoveDirection> new_list = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            if (args.get(i).equals("f") || args.get(i).equals("forward")) {
                new_list.add(MoveDirection.FORWARD);
            } else if (args.get(i).equals("b") || args.get(i).equals("backward")) {
                new_list.add(MoveDirection.BACKWARD);
            } else if (args.get(i).equals("r") || args.get(i).equals("right")) {
                new_list.add(MoveDirection.RIGHT);
            } else if (args.get(i).equals("l") || args.get(i).equals("left")) {
                new_list.add(MoveDirection.LEFT);
            }else{
                throw new IllegalArgumentException(args.get(i) + " is not legal move specification");
            }
        }
        return new_list.toArray(new MoveDirection[0]);
    }
}
