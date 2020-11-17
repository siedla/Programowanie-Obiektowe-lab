package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

import java.util.Random;

public class GrassField extends AbstaractWorldMap {

    public GrassField(int n){
        int[][] occupied = new int[(int) Math.sqrt(n * 10)][(int) Math.sqrt(n * 10)];
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            int x = rand.nextInt((int) Math.sqrt(n * 10));
            int y = rand.nextInt((int) Math.sqrt(n * 10));
            if(occupied[x][y] == 0){
                occupied[x][y] = 1;
                Grass newGrass = new Grass(new Vector2d(x,y));
                grassMap.put(newGrass.getPosition(), newGrass);
                grass.add(newGrass);
            }
            else i--;
        }
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
