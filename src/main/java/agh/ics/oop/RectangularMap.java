package agh.ics.oop;
import java.util.List;
import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;
    private final Vector2d lowerLeft;
    private final Vector2d upperRight;

    public RectangularMap(int width, int height){
        super();
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(this.width - 1,this.height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if (!isOccupied(position) & position.precedes(this.upperRight) & position.follows(this.lowerLeft)){
            return true;
        }
        return false;
    }

    public Vector2d getLowerLeft(){
        return this.lowerLeft;
    }

    public Vector2d getUpperRight(){
        return this.upperRight;
    }
}
