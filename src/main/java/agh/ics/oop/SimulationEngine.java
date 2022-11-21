package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final List<MoveDirection> directions;
    private final IWorldMap map;
    private final List<Animal> animals;

    private final List<Vector2d> positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialPositions){
        this.directions = Arrays.stream(directions).toList();
        this.map = map;
        this.animals = new ArrayList<>();
        this.positions = Arrays.stream(initialPositions).toList();

        for(int i = 0; i < positions.size(); i++){
            Animal a = new Animal(map, positions.get(i));
            this.map.place(a);
            this.animals.add(a);
        }
    }

    public void run(){
        for (int i = 0; i < this.directions.size(); i++) {
            this.animals.get(i % this.animals.size()).move(this.directions.get(i));
        }
    }

    public Animal getAnimal(int n){
        return this.animals.get(n);
    }
}

