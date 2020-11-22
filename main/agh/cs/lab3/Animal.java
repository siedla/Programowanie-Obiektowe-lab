package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.AbstractWorldMapElement;
import agh.cs.lab6.IPositionChangeObserver;
import agh.cs.lab6.IPositionChangePublisher;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement implements IPositionChangePublisher {

    private MapDirection orientation = MapDirection.NORTH;
    private final IWorldMap map;
    private final ArrayList<IPositionChangeObserver> observerList;
    public Animal(IWorldMap map, Vector2d initialPosition){
        observerList = new ArrayList<>();
        position = initialPosition;
        this.map = map;
    }


    public Animal(IWorldMap map){
        this(map, new Vector2d(2, 2));
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case WEST -> "<";
            case EAST -> ">";
        };

    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                if(map.canMoveTo(position.add(orientation.toUnitVector()))){
                    position =position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if(map.canMoveTo(position.add(orientation.toUnitVector().opposite()))){
                    position = position.add(orientation.toUnitVector().opposite());
                }
            }
        }

    }

    public boolean isPassable() {
        return false;
    }

    @Override
    public void addObserver(IPositionChangeObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IPositionChangeObserver observer) {
        observerList.remove(observer);
    }

    public void notifyChangePosition(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver o: observerList){
            o.positionChanged(this, oldPosition, newPosition);
        }
    }
}
