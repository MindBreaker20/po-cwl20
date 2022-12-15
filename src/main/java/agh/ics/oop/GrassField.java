package agh.ics.oop;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap{
    private MapBoundary mapBoundary;

    public GrassField(int n){
        super();
        this.mapBoundary = new MapBoundary();

        for(int i = 0; i < n; i++){ // Randomowe umiesczanie trawy
            int x = (int)(Math.random() * (Math.sqrt(n * 10)));
            int y = (int)(Math.random() * (Math.sqrt(n * 10)));
            if (!isOccupied(new Vector2d(x, y))){
                Grass grass = new Grass(this, new Vector2d(x, y));
                place(grass);
            }
        }
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
    public boolean place(IMapElement element){
        if(super.place(element)){
            if(element instanceof IObserverEnabler) {
                ((IObserverEnabler) element).addObserver(mapBoundary);
            }
            mapBoundary.addElement(element);
            return true;

        }
        return false;
    }

}
