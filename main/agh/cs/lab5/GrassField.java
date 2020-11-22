package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

import java.util.*;

public class GrassField extends AbstaractWorldMap {

    private final Map<Vector2d, AbstractWorldMapElement> grassMap = new HashMap<>();
    private final LinkedList<Grass> grass = new LinkedList<>();
    public GrassField(int n){
        int[][] occupied = new int[(int) Math.sqrt(n * 10)][(int) Math.sqrt(n * 10)];
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            int x = rand.nextInt((int) Math.sqrt(n * 10));
            int y = rand.nextInt((int) Math.sqrt(n * 10));
            if(occupied[x][y] == 0){
                occupied[x][y] = 1;
                Grass newGrass = new Grass(new Vector2d(x,y));
                elements.addToList(newGrass);
                grassMap.put(newGrass.getPosition(), newGrass);
                grass.add(newGrass);
            }
            else i--;
        }
    }

    public Optional<AbstractWorldMapElement> objectAt(Vector2d position){
        if(super.objectAt(position).isPresent()){
            return super.objectAt(position);
        }
        AbstractWorldMapElement grassAt = grassMap.get(position);
        if(grassAt!=null){
            return Optional.of(grassAt);
        }
        return Optional.empty();
    }
    public Vector2d[] minMax(){
        Vector2d min = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        Vector2d max = new Vector2d(0,0);
        for(AbstractWorldMapElement animal : animals){
            min = min.lowerLeft(animal.getPosition());
            max = max.upperRight(animal.getPosition());
        }
        for(AbstractWorldMapElement grass:grass){
            min = min.lowerLeft(grass.getPosition());
            max = max.upperRight(grass.getPosition());
        }

        return new Vector2d[]{min, max};
    }
}
