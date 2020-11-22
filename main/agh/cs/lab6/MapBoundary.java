package agh.cs.lab6;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstractWorldMapElement;

import java.util.LinkedList;

public class MapBoundary implements IPositionChangeObserver{
    CompareByX comparatorX = new CompareByX();
    CompareByY comparatorY = new CompareByY();
    LinkedList<AbstractWorldMapElement> inOrderX = new LinkedList<>();
    LinkedList<AbstractWorldMapElement> inOrderY = new LinkedList<>();

    @Override
    public void positionChanged(AbstractWorldMapElement movedElement, Vector2d oldPosition, Vector2d newPosition) {

        if(movedElement.getPosition().x > inOrderX.getLast().getPosition().x || movedElement.getPosition().x < inOrderX.getFirst().getPosition().x ){
            inOrderX.sort(comparatorX);
        }
        if(movedElement.getPosition().y > inOrderY.getLast().getPosition().y || movedElement.getPosition().y < inOrderY.getFirst().getPosition().y ){
            inOrderY.sort(comparatorY);
        }
        if(movedElement.equals(inOrderX.getFirst()) || movedElement.equals(inOrderX.getLast())){
            inOrderX.sort(comparatorX);
        }
        if(movedElement.equals(inOrderY.getFirst()) || movedElement.equals(inOrderY.getLast())){
            inOrderY.sort(comparatorY);
        }
    }

    public void addToList(AbstractWorldMapElement newElement){
        inOrderX.add(newElement);
        inOrderY.add(newElement);
        inOrderX.sort(comparatorX);
        inOrderY.sort(comparatorY);
    }

    public Vector2d upperRight(){
        return new Vector2d(inOrderX.getLast().getPosition().x, inOrderY.getLast().getPosition().y);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(inOrderX.getFirst().getPosition().x, inOrderY.getFirst().getPosition().y);
    }
}
