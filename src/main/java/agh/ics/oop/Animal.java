package agh.ics.oop;

public class Animal{
    private MapDirection mapDirection;
    private Vector2d position;
    private IWorldMap map;
    public Animal(){
        this.mapDirection = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }
    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2)); // uproszczenie konstruktorów za pomocą this()
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.mapDirection = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public String toString(){
        //return "(" + this.position.x + "," + this.position.y + ") " + this.mapDirection;
        return this.mapDirection.Abbreviation();
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        if(direction == MoveDirection.RIGHT){
            this.mapDirection = mapDirection.next();
        }
        else if(direction == MoveDirection.LEFT){
            this.mapDirection = mapDirection.previous();
        }
        else if(direction == MoveDirection.FORWARD){
            Vector2d newPosition = position.add(mapDirection.toUnitVector());
            // if(newPosition.precedes(new Vector2d(4,4)) & newPosition.follows(new Vector2d(0,0)))
            if(map.canMoveTo(newPosition)){
                this.position = newPosition;
            }
        }
        else if(direction == MoveDirection.BACKWARD){
            Vector2d newPosition = position.subtract(mapDirection.toUnitVector());
            // if(newPosition.precedes(new Vector2d(4,4)) & newPosition.follows(new Vector2d(0,0)))
            if(map.canMoveTo(newPosition)){
                this.position = newPosition;
            }
        }
    }

    public MapDirection getMapDirection(){
        return this.mapDirection;
    }

    public Vector2d getPosition(){
        return this.position;
    }

}

