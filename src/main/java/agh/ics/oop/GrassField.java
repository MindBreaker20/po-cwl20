package agh.ics.oop;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{
    private List<Grass> grasses;

    public GrassField(int n){
        super();
        this.grasses = new ArrayList<>();

        for(int i = 0; i < n; i++){ // Randomowe umiesczanie trawy
            int x = (int)(Math.random() * (Math.sqrt(n * 10)));
            int y = (int)(Math.random() * (Math.sqrt(n * 10)));
            if (!isOccupied(new Vector2d(x, y))){
                Grass g = new Grass(this, new Vector2d(x, y));
                this.grasses.add(g);
                break;
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
    protected Vector2d getLowerLeft(){ // Metoda zwracająca minimlany dolny lewy punkt
        Vector2d lowerLeft = super.getAnimals().get(0).getPosition();
        for(int i = 0; i < super.getAnimals().size(); i++){
            if (super.getAnimals().get(i).getPosition().precedes(lowerLeft)){ // Sprawdzanie czy badana pozycja zwierzecia jest mniejsza od dotychczasowej
                lowerLeft = super.getAnimals().get(i).getPosition();
            }
        }
        for(int j = 0; j < this.grasses.size(); j++){
            if (this.grasses.get(j).getPosition().precedes(lowerLeft)){ // Sprawdzanie czy badana pozycja trawy jest mniejsza od zwierzecej
                lowerLeft = this.grasses.get(j).getPosition();
            }
        }
        return lowerLeft;
    }

    protected Vector2d getUpperRight(){ // Metoda zwracająca maksymalny górny prawy punkt
        Vector2d upperRight = super.getAnimals().get(0).getPosition();
        for(int i = 0; i < super.getAnimals().size(); i++){
            if (super.getAnimals().get(i).getPosition().follows(upperRight)){ // Sprawdzanie czy badana pozycja zwierzecia jest wieksza od dotychczasowej
                upperRight = super.getAnimals().get(i).getPosition();
            }
        }
        for(int j = 0; j < this.grasses.size(); j++){
            if (this.grasses.get(j).getPosition().follows(upperRight)){ // Sprawdzanie czy badana pozycja trawy jest większa od zwierzecej
                upperRight = this.grasses.get(j).getPosition();
            }
        }
        return upperRight;
    }

}
