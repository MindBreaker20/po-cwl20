package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animals;
    private final MapVisualizer visualizer;

    public AbstractWorldMap(){
        this.animals = new HashMap<>();
        this.visualizer = new MapVisualizer(this);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals.get(oldPosition); // uzyskanie obiektu zwierzę po kluczu stara pozycja
        this.animals.remove(oldPosition); // usuniecie zwierzecia po starym kluczu
        this.animals.put(newPosition, animal); // dodanie zwierzecia z nowym kluczem (pozycja)
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if (!isOccupied(position)){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal){
        if (!isOccupied(animal.getPosition())){
            this.animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        return this.animals.get(position);
    }

    @Override
    public String toString(){
        return visualizer.draw(getLowerLeft(), getUpperRight());
    }

    public Map<Vector2d, Animal> getAnimals(){ // getter używany w klasie GrasssField do szukania skrajnych punktów zwierząt i traw
        return this.animals;
    }

    protected abstract Vector2d getLowerLeft();

    protected abstract Vector2d getUpperRight();
}
