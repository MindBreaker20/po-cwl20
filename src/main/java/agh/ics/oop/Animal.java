package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement implements IObserverEnabler{
    private MapDirection mapDirection;
    private final List<IPositionChangeObserver> observers;

    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2)); // uproszczenie konstruktorów za pomocą this()
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(map, initialPosition);
        this.mapDirection = MapDirection.NORTH;
        this.observers = new ArrayList<>();
    }

    public String toString(){
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
            if(map.canMoveTo(newPosition)){
                positionChanged(this.position, newPosition);
                this.position = newPosition;
            }
        }
        else if(direction == MoveDirection.BACKWARD){
            Vector2d newPosition = position.subtract(mapDirection.toUnitVector());
            if(map.canMoveTo(newPosition)){
                positionChanged(this.position, newPosition);
                this.position = newPosition;
            }
        }
    }

    public MapDirection getMapDirection(){
        return this.mapDirection;
    }

    @Override
    public void addObserver(IPositionChangeObserver observer){
        if(!this.observers.contains(observer)){
            this.observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(int i = 0; i < this.observers.size(); i++){
            this.observers.get(i).positionChanged(oldPosition, newPosition);
        }
    }

}

