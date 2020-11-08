package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualiser;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class AbstaractWorldMap implements IWorldMap {
     protected final Vector2d lowerLeft = new Vector2d(0, 0);
     protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
     protected LinkedList<Animal> animals = new LinkedList<>();
     LinkedList<Grass> grass = new LinkedList<>();

    public AbstaractWorldMap(){}


    public void run(List<MoveDirection> directions) {
        int numberOfAnimals = animals.size();

        for(int i = 0; i < directions.size(); i++){
            animals.get(i % numberOfAnimals).move(directions.get(i));
        }
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();

    }

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    public void toString(IWorldMap map) {
        MapVisualiser draw = new MapVisualiser(map);
        Vector2d[] minMax = minMax();
        System.out.println(draw.draw(minMax[0], minMax[1]));
    }

    public Optional<Object> objectAt(Vector2d position) {
        for(Animal animal : animals){
            if(position.equals(animal.getPosition()))
                return  Optional.of(animal);
        }
        for(Grass grass : grass){
            if(position.equals((grass.getPosition())))
                return Optional.of(grass);
        }
        return Optional.empty();
    }

    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight ) && !isOccupiedByAnimal(position);
    }

    public boolean isOccupiedByAnimal(Vector2d position){
        for(Animal animal : animals) {
            if (position.equals(animal.getPosition()))
                return true;
        }
        return false;
    }

    public Vector2d getPosition(int i){
        return animals.get(i).getPosition();
    }

    public String getDirection(int i){
        return  animals.get(i).toString();
    }

    abstract public Vector2d[] minMax();
}
