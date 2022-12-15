package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, IMapElement> mapElements; // 0d lab8 - Upewnij się, że elementy te nie są niepotrzebnie tworzone wielokrotnie.
//    protected Map<Vector2d, Animal> animals;
//    protected Map<Vector2d, Grass> grasses;
    private final MapVisualizer visualizer;

    public AbstractWorldMap(){
        this.mapElements = new LinkedHashMap<>();
        this.visualizer = new MapVisualizer(this);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement element = this.mapElements.get(oldPosition);
        this.mapElements.remove(oldPosition);
        this.mapElements.put(newPosition, element);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if (!isOccupied(position)){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(IMapElement element){
        if (!isOccupied(element.getPosition())){
            this.mapElements.put(element.getPosition(), element);
            if(element instanceof IObserverEnabler) {
                ((IObserverEnabler) element).addObserver(this);
            }
            return true;
        }else{
            throw new IllegalArgumentException("Animal cannot be placed on " + element.getPosition());
        }
    }

    @Override
    public IMapElement objectAt(Vector2d position){
        return this.mapElements.get(position);
    }

    @Override
    public String toString(){
        return visualizer.draw(getLowerLeft(), getUpperRight());
    }

    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    public Map<Vector2d, IMapElement> getMapElements(){
        return this.mapElements;
    }
    
    public abstract Vector2d getLowerLeft();

    public abstract Vector2d getUpperRight();
}
