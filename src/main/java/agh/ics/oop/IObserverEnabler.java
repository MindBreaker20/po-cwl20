package agh.ics.oop;

public interface IObserverEnabler {
    void removeObserver(IPositionChangeObserver observer);
    void addObserver(IPositionChangeObserver observer);
}
