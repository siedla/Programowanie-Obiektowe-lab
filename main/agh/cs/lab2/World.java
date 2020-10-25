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

