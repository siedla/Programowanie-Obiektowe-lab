package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

public abstract class AbstractWorldMapElement {
    protected Vector2d position;

    public Vector2d getPosition(){
        return position;
    }

    public abstract String toString();

    public abstract boolean isPassable();
}
