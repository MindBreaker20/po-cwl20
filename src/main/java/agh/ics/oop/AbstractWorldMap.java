package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals;
    private final MapVisualizer visualizer;

    public AbstractWorldMap(){
        this.animals = new ArrayList<>();
        this.visualizer = new MapVisualizer(this);
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
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for (int i = 0; i < this.animals.size(); i++){
            Animal animal = animals.get(i);
            if (animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return visualizer.draw(getLowerLeft(), getUpperRight());
    }

    public List<Animal> getAnimals(){ // getter używany w klasie GrasssField do szukania skrajnych punktów zwierząt i traw
        return this.animals;
    }

    protected abstract Vector2d getLowerLeft();

    protected abstract Vector2d getUpperRight();
}
