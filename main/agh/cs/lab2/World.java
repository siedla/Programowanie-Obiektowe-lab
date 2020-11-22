package agh.cs.lab2;

import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab5.AbstaractWorldMap;
import agh.cs.lab5.GrassField;

import java.util.List;

public class World {
    public static void main(String[] args) {
        try{
            String[] moves = {"f", "b", "r", "l","f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            List<MoveDirection> directions = OptionsParser.parse(moves);

            AbstaractWorldMap map = new GrassField(3);
            map.place(new Animal(map));
            map.place(new Animal(map,new Vector2d(3,4)));
            map.run(directions);
            map.toString(map);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

    }
}

