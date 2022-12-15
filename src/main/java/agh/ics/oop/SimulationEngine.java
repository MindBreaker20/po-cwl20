package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{
    private List<MoveDirection> directions;
    private final IWorldMap map;
    private final List<Animal> animals;
    private final List<IAnimalPositionChangeObserver> observers;

    private long moveDelay; // typ long dla milisekund

    public SimulationEngine(List<MoveDirection> directions, IWorldMap map, List<Vector2d> initialPositions){
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.moveDelay = 0;

        for(int i = 0; i < initialPositions.size(); i++){
            Animal animal = new Animal(map, initialPositions.get(i));
            this.map.place(animal);
            this.animals.add(animal);
        }
    }

    public void setMoveDirections(List<MoveDirection> directions){
        this.directions = directions;
    }

    public void setMoveDelay(long number){
        this.moveDelay = number;
    }

    public void run(){
        for (int i = 0; i < this.directions.size(); i++) {
            this.animals.get(i % this.animals.size()).move(this.directions.get(i));

            for(int j = 0; j < this.observers.size(); j++){
                this.observers.get(j).animalPositionChange();
            }

            if(moveDelay > 0){
                try{
                    Thread.sleep(moveDelay);
                }catch(InterruptedException e){
                    System.out.println("Symulacja została przerwana");
                }
            }
        }
    }

    public void addObserver(IAnimalPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public Animal getAnimal(int n){
        return this.animals.get(n);
    }
}

