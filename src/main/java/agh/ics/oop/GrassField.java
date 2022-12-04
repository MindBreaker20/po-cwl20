package agh.ics.oop;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap{
    private final MapBoundary mapBoundary;
    private Map<Vector2d, Grass> grasses;

    public GrassField(int n){
        super();
        this.grasses = new HashMap<>();
        this.mapBoundary = new MapBoundary();

        for(int i = 0; i < n; i++){ // Randomowe umiesczanie trawy
            int x = (int)(Math.random() * (Math.sqrt(n * 10)));
            int y = (int)(Math.random() * (Math.sqrt(n * 10)));
            if (!isOccupied(new Vector2d(x, y))){
                Grass grass = new Grass(this, new Vector2d(x, y));
                this.grasses.put(new Vector2d(x, y), grass);
                this.mapBoundary.addGrass(grass);
            }
        }
    }

    @Override // Umożliwia nieograniczone poruszanie się zwierzęcia po mapie, pod warunkiem, że nie wchodzi na inne zwierzę - rozmiar mapy ma być "nieskończony"
    public boolean canMoveTo(Vector2d position){
        if (!isOccupied(position) & position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE))
                & position.follows(new Vector2d(0, 0))){
            return true;
        }
        return false;
    }

    //  Rysowanie fragmentu mapy, na którym znajdują się wszystkie elementy (zwierzęta oraz trawa). Dynamiczne obliczaie skrajnych punktów
    @Override
    public Vector2d getLowerLeft(){ // Metoda zwracająca minimlany dolny lewy punkt
        return this.mapBoundary.getLowerLeft();
    }

    @Override
    public Vector2d getUpperRight(){ // Metoda zwracająca maksymalny górny prawy punkt
        return this.mapBoundary.getUpperRight();
    }

    @Override
    public Map<Vector2d, Grass> getGrasses(){
        return this.grasses;
    }
}
