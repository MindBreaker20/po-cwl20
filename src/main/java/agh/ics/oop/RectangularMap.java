package agh.ics.oop;
import java.util.List;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int height;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;
    private final List<Animal> animals;
    private final MapVisualizer visualizer;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(this.width - 1, this.height - 1);
        this.upperRight = new Vector2d(4,4);
        this.animals = new ArrayList<>();
        this.visualizer = new MapVisualizer(this);
    }

    public boolean canMoveTo(Vector2d position){
        if (position.precedes(this.upperRight) & (position.follows(this.lowerLeft))){
            return isOccupied(position);
        }
        return false;
    }

    public boolean place(Animal animal){
        if (isOccupied(animal.getPosition()) == false){
            this.animals.add(animal);
            return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position){
        for (int i = 0; i < this.animals.size(); i++){
            Animal animal = animals.get(i);
            return animal.isAt(position);
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        for (int i = 0; i < this.animals.size(); i++){
            Animal animal = animals.get(i);
            if (animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }

    public String toString(){
        return visualizer.draw(this.lowerLeft, this.upperRight);
    }

}
