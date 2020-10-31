package lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorldTest {

    @Test
    void main() {
        String[] moves = {"f", "b", "r", "l","f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(moves);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);

        Animal animal0 = map.animalForTheTest(0);
        Animal animal1 = map.animalForTheTest(1);

        assertEquals(new Vector2d(2,3), animal0.getPosition());// Sprawdzam czy po pierwszych 6 ruchach zwierzaki nie weszły na siebie
        assertEquals(new Vector2d(3,3), animal1.getPosition());

        assertEquals(">", animal0.toString()); // Sprawdzam czy są zwrócone w dobrym kierunku
        assertEquals("<", animal1.toString());

        String[] moves2 = {"r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions2 = new OptionsParser().parse(moves2);
        map.run(directions2);

        assertEquals(new Vector2d(2,0), animal0.getPosition());// Sprawdzam czy nie wychodzą za mape
        assertEquals(new Vector2d(3,5), animal1.getPosition());

    }
}