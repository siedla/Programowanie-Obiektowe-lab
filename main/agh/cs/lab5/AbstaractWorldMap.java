package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualiser;
import agh.cs.lab6.IPositionChangeObserver;
import agh.cs.lab6.MapBoundary;

import java.util.*;

public abstract class AbstaractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected static final Vector2d lowerLeft = new Vector2d(0, 0);
    protected Vector2d upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected LinkedList<Animal> animals = new LinkedList<>();
    protected Map<Vector2d,AbstractWorldMapElement> animalMap = new HashMap<>();

    protected MapBoundary elements = new MapBoundary();
    public void run(List<MoveDirection> directions) {
        int numberOfAnimals = animals.size();

        for(int i = 0; i < directions.size(); i++){
            Animal current = animals.get(i % numberOfAnimals);
            Vector2d positionBefore = current.getPosition();
            current.move(directions.get(i));
            Vector2d positionAfter = current.getPosition();
            if(!positionBefore.equals(positionAfter)){
                current.notifyChangePosition(positionBefore, positionAfter);
            }
        }
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();

    }

    public boolean place(Animal animal) {

        if(canMoveTo(animal.getPosition())){
            animal.addObserver(this);
            animal.addObserver(elements);
            elements.addToList(animal);
            animalMap.put(animal.getPosition(),animal);
            animals.add(animal);
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition().toString() + " to pole jest juz zajete");
    }

    public void toString(IWorldMap map) {
        MapVisualiser draw = new MapVisualiser(map);
        System.out.println(draw.draw(elements.lowerLeft(), elements.upperRight()));

    }

    public Optional<AbstractWorldMapElement> objectAt(Vector2d position) {

        AbstractWorldMapElement animalAt = animalMap.get(position);
        if(animalAt != null)
            return Optional.of(animalAt);

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

    @Override
    public void positionChanged(AbstractWorldMapElement movedElement,Vector2d oldPosition, Vector2d newPosition) {
        animalMap.remove(oldPosition);
        animalMap.put(newPosition, movedElement);
    }

    abstract protected Vector2d[] minMax();
}
