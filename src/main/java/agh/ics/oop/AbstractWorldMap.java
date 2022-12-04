package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    private final MapBoundary mapBoundary;
    protected Map<Vector2d, Animal> animals;

    protected Map<Vector2d, Grass> grasses;
    private final MapVisualizer visualizer;

    public AbstractWorldMap(){
        this.mapBoundary = new MapBoundary();
        this.animals = new HashMap<>();
        this.grasses = new HashMap<>();
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
            this.mapBoundary.addAnimal(animal);
            return true;
        }else{
            throw new IllegalArgumentException("Animal cannot be placed on " + animal.getPosition());
        }
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

    public Map<Vector2d, Grass> getGrasses(){
        return this.grasses;
    }
    
    public abstract Vector2d getLowerLeft();

    public abstract Vector2d getUpperRight();
}
