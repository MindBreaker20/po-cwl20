package agh.ics.oop;

import java.util.Map;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Zachód";
            case EAST:
                return "Wschód";
        }
        return "";
    }

    public MapDirection next(){
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
        }
        return this;
    }

    public MapDirection previous(){
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            case EAST:
                return NORTH;
        }
        return this;
    }

    public Vector2d toUnitVector(){
        int num1 = 0;
        int num2 = 0;
        switch (this) {
            case NORTH:
                num2 = 1;
                break;
            case SOUTH:
                num2 = -1;
                break;
            case WEST:
                num1 = -1;
                break;
            case EAST:
                num1 = 1;
                break;
        }
        Vector2d new_vector = new Vector2d(num1, num2);
        return new_vector;
    }
}

