package agh.ics.oop;

public abstract class AbstractWorldMapElement implements IMapElement{
    protected Vector2d position;
    protected IWorldMap map;

    public AbstractWorldMapElement(IWorldMap map, Vector2d position){
        this.position = position;
        this.map = map;
    }

    @Override
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public boolean isAt(Vector2d position){
        return  this.position.equals(position);
    }

}
