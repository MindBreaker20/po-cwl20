package agh.ics.oop;

public class Grass extends AbstractWorldMapElement{

    public Grass(IWorldMap map, Vector2d position){
        super(map, position);
    }

    public String toString(){
        return "*";
    }

    @Override
    public String getResourceName(){
        return "grass";
    }

    @Override
    public String getName(){
        return "";
    }
}
