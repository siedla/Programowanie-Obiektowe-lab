package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class RectangularMap implements IWorldMap{

    private final static Vector2d lowerLeft = new Vector2d(0, 0);

    private static Vector2d upperRight;
    private final LinkedList<Animal> animals = new LinkedList<>();

    public RectangularMap(int width, int height){
        upperRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight ) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void run(List<MoveDirection> directions) {
        int numberOfAnimals = animals.size();

        for(int i = 0; i < directions.size(); i++){
            animals.get(i % numberOfAnimals).move(directions.get(i));
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals){
            if(position.equals(animal.getPosition()))
                return true;
        }
        return false;
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        for(Animal animal : animals){
            if(position.equals(animal.getPosition()))
                return  Optional.of(animal);


        }
        return Optional.empty();
    }

    public void toString(IWorldMap map){
        MapVisualiser draw = new MapVisualiser(map);
        System.out.println(draw.draw(lowerLeft, upperRight));
    }

    public Vector2d getPosition(int i){
        return animals.get(i).getPosition();
    }

    public String getDirection(int i){
        return  animals.get(i).toString();
    }
}
