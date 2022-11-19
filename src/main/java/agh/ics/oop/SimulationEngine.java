package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final List<MoveDirection> directions;
    private final IWorldMap map;
    private final List<Animal> animals;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] initialPositions){
        this.directions = Arrays.stream(directions).toList();
        this.map = map;
        this.animals = new ArrayList<>();
        for(int i = 0; i < Arrays.stream(initialPositions).toList().size(); i++){
            Animal a = new Animal(map, Arrays.stream(initialPositions).toList().get(i));
            this.map.place(a);
            this.animals.add(a);
        }
    }

    public void run(){
        int animalIndex = 0;
        for(int i = 0; i < this.directions.size(); i++){
            if(animalIndex != this.animals.size()){
                this.animals.get(animalIndex).move(this.directions.get(i));
                animalIndex += 1;
            }else{
                animalIndex = 0;
            }
        }
    }

    public Animal getAnimal(int n){
        return this.animals.get(n);
    }
}
