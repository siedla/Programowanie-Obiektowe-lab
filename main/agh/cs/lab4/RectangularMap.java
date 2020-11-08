package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstaractWorldMap;

public class RectangularMap extends AbstaractWorldMap {

    public RectangularMap(int width, int height){
        upperRight = new Vector2d(width, height);
    }

    @Override
    public Vector2d[] minMax() {
        return new Vector2d[]{lowerLeft, upperRight};
    }


}
