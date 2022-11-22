package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{

//    private Vector2d position;

    public Grass(IWorldMap map, Vector2d position){
        super(map, position);
//        this.position = position;
    }

//    public Vector2d getPosition(){
//        return this.position;
//    }

    public String toString(){
        return "*";
    }
}
