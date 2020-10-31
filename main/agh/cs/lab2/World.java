package agh.cs.lab2;

import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;

import java.util.List;

public class World {
    public static void main(String[] args) {
        String[] moves = {"f", "b", "r", "l","f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(moves);


        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        System.out.println(map.canMoveTo(new Vector2d(2,5)));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        map.toString(map);



    }

}

