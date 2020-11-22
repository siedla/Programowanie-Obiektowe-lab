package agh.cs.lab6;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstractWorldMapElement;

public interface IPositionChangeObserver {
    void positionChanged(AbstractWorldMapElement movedElement, Vector2d oldPosition, Vector2d newPosition);

}
