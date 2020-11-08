package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal{

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;
    private final IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
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
                if(map.canMoveTo(position.add(orientation.toUnitVector())))
                    position =position.add(orientation.toUnitVector());
                }
            case BACKWARD -> {
                if(map.canMoveTo(position.add(orientation.toUnitVector().opposite())))
                    position = position.add(orientation.toUnitVector().opposite());
                }
            }
    }

    public Vector2d getPosition(){
        return position;
    }


}
