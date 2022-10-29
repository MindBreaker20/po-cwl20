package agh.ics.oop;

public class Animal {
    private MapDirection mapdirection = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    public MapDirection mapDirection = mapdirection; // dostęp do wartosci prywatnego atrybutu na potrzeby testów z punktu 9
    public Vector2d Position = position;

    public String toString(){
        return "(" + this.position.x + "," + this.position.y + ") " + this.mapdirection;
    }

    public boolean isAt(Vector2d position){
        if(this.position.equals(position)==true){
            return true;
        }
        return false;
    }
    public void move(MoveDirection direction){
        Vector2d position_0_0 = new Vector2d(0, 0);
        Vector2d position_4_4 = new Vector2d(4, 4);

        if(direction == MoveDirection.RIGHT){
            mapdirection = mapdirection.next();
        }
        else if(direction == MoveDirection.LEFT){
            mapdirection = mapdirection.previous();
        }
        else if(direction == MoveDirection.FORWARD){
            Vector2d new_position = position.add(mapdirection.toUnitVector());
            if(new_position.precedes(position_4_4) == true){
                position = new_position;
            }
        }
        else if(direction == MoveDirection.BACKWARD){
            Vector2d new_position = position.subtract(mapdirection.toUnitVector());
            if(new_position.follows(position_0_0) == true){
                position = new_position;
            }
        }
    }

}
