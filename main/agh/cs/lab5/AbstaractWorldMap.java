package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualiser;

import java.util.*;

public abstract class AbstaractWorldMap implements IWorldMap {

    protected static final Vector2d lowerLeft = new Vector2d(0, 0);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected LinkedList<Animal> animals = new LinkedList<>();
    protected LinkedList<Grass> grass = new LinkedList<>();
    protected Map<Vector2d,AbstractWorldMapElement> animalMap = new HashMap<>();
    protected Map<Vector2d, AbstractWorldMapElement> grassMap = new HashMap<>();

    public void run(List<MoveDirection> directions) {
        int numberOfAnimals = animals.size();

        for(int i = 0; i < directions.size(); i++){
            Animal current = animals.get(i % numberOfAnimals);
            Vector2d positionBefore = current.getPosition();
            current.move(directions.get(i));
            Vector2d positionAfter = current.getPosition();
            if(!positionBefore.equals(positionAfter)){
                animalMap.remove(positionBefore);
                animalMap.put(positionAfter,current);
            }
        }
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();

    }

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animalMap.put(animal.getPosition(),animal);
            animals.add(animal);
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition().toString() + " to pole jest juz zajete");
    }

    public void toString(IWorldMap map) {
        MapVisualiser draw = new MapVisualiser(map);
        Vector2d[] minMax = minMax();
        System.out.println(draw.draw(minMax[0], minMax[1]));

    }

    public Optional<AbstractWorldMapElement> objectAt(Vector2d position) {
        AbstractWorldMapElement grassAt = grassMap.get(position);
        AbstractWorldMapElement animalAt = animalMap.get(position);
        if(animalAt != null)
            return Optional.of(animalAt);
        if(grassAt != null)
            return Optional.of(grassAt);
        return Optional.empty();
    }

    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight ) && ((!isOccupied(position)) || objectAt(position).get().isPassable());
    }

    public Vector2d getPosition(int i){
        return animals.get(i).getPosition();
    }

    public String getDirection(int i){
        return  animals.get(i).toString();
    }

    abstract protected Vector2d[] minMax();
}
