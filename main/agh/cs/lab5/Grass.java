package agh.cs.lab5;

import agh.cs.lab2.Vector2d;


public class Grass {
    private final Vector2d postion;

    public Grass(Vector2d initialPostion){
        postion = initialPostion;
    }

    public Vector2d getPosition(){
        return postion;
    }

    public String toString() {
        return "*";
    }


}
