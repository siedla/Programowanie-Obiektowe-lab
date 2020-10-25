<<<<<<< HEAD
package agh.cs.lab2;

import java.util.LinkedList;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal.toString());
        LinkedList<MoveDirection> moves2 = OptionsParser.parse(args);
        for(MoveDirection move : moves2){
            animal.move(move);
        }
        System.out.println(animal.toString());

    }

}
=======
package agh.cs.lab2;

import agh.cs.lab1.Direction;

public class World {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

    }

}
>>>>>>> f03ca5454e3754f7bb29ab8213e5c1819c14e578
