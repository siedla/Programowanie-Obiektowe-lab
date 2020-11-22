package agh.cs.lab6;

public interface IPositionChangePublisher {
    void addObserver(IPositionChangeObserver observer);

    void removeObserver(IPositionChangeObserver observer);
}
