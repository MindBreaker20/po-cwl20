package agh.ics.oop;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;

public class MapBoundary implements IPositionChangeObserver{
    private final List<Vector2d> sortedListX;
    private final List<Vector2d> sortedListY;

    public MapBoundary(){
        this.sortedListX = new LinkedList<>();
        this.sortedListY = new LinkedList<>();
    }

    public void addAnimal(Animal animal){
        this.sortedListX.add(animal.getPosition());
        this.sortedListY.add(animal.getPosition());
        this.sortedListX.sort(Comparator.comparing(Vector2d::getX));
        this.sortedListY.sort(Comparator.comparing(Vector2d::getY));
    }

    public void addGrass(Grass grass){
        this.sortedListX.add(grass.getPosition());
        this.sortedListY.add(grass.getPosition());
        this.sortedListX.sort(Comparator.comparing(Vector2d::getX));
        this.sortedListY.sort(Comparator.comparing(Vector2d::getY));
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        this.sortedListX.remove(oldPosition);
        this.sortedListX.add(newPosition);

        this.sortedListY.remove(oldPosition);
        this.sortedListY.add(newPosition);
    }

    public Vector2d getLowerLeft(){
        return new Vector2d(this.sortedListX.get(0).x, this.sortedListY.get(0).y);
    }

    public Vector2d getUpperRight(){
        return new Vector2d(this.sortedListX.get(this.sortedListX.size() - 1).x,
                this.sortedListY.get(this.sortedListY.size() - 1).y);
    }
}
