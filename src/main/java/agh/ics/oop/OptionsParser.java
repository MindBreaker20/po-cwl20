package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public MoveDirection[] parse(String[] args) {
        List<MoveDirection> new_list = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("f") || args[i].equals("forward")) {
                new_list.add(MoveDirection.FORWARD);
            } else if (args[i].equals("b") || args[i].equals("backward")) {
                new_list.add(MoveDirection.BACKWARD);
            } else if (args[i].equals("r") || args[i].equals("right")) {
                new_list.add(MoveDirection.RIGHT);
            } else if (args[i].equals("l") || args[i].equals("left")) {
                new_list.add(MoveDirection.LEFT);
            }
        }
        return new_list.toArray(new MoveDirection[0]);
    }
}
