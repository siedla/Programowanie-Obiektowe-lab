package agh.cs.lab2;

import java.util.LinkedList;

public class OptionsParser {

    public static LinkedList<MoveDirection> parse(String[] moves){
        LinkedList<MoveDirection> list = new LinkedList<>();
        for (String move : moves){
            switch (move){
                case "backward", "b" -> list.add(MoveDirection.BACKWARD);
                case "forward", "f" -> list.add(MoveDirection.FORWARD);
                case "left", "l" -> list.add(MoveDirection.LEFT);
                case "right", "r" -> list.add(MoveDirection.RIGHT);
            }
        }
        return list;
    }
}
