<<<<<<< HEAD:main/pl/edu/agh/po/lab01/World.java
package pl.edu.agh.po.lab01;
import java.util.Scanner;
import agh.cs.lab1.Direction;

public class World {
    public static void main(String[] args){
        System.out.println("Start systemu");
        Scanner scan = new Scanner(System.in);
        String moves = scan.nextLine();
        Direction[] tab = change(moves);
        run(tab);
        System.out.println("Zakończenie działania systemu");

    }
    public static void run(Direction[] args) {

        for (Direction arg : args) {
            if(arg==null){
                continue;
            }
            switch (arg) {
                case FORWARD -> System.out.print("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.print("Zwierzak idzie do tyłu");
                case LEFT -> System.out.print("Zwierzak idzie w lewl ro");
                case RIGHT -> System.out.print("Zwierzak idzie w prawo");

            }
            System.out.println();
        }
    }
    public static Direction[] change(String args){
        Direction[] direction= new Direction[args.length()];
        int j =0;
        for (int i =0; i<args.length(); i++) {
            switch (args.charAt(i)) {
                case 'f' -> direction[j] = Direction.FORWARD;
                case 'b' -> direction[j] = Direction.BACKWARD;
                case 'l' -> direction[j] = Direction.LEFT;
                case 'r' -> direction[j] = Direction.RIGHT;
                default -> j--;
            }
            j++;
        }
        return direction;
    }
}
=======
package pl.edu.agh.po.lab01;
import java.util.Scanner;
import agh.cs.lab1.Direction;

public class World {
    public static void main(String[] args){
        System.out.println("Start systemu");
        Scanner scan = new Scanner(System.in);
        String moves = scan.nextLine();
        Direction[] tab = change(moves);
        run(tab);
        System.out.println("Zakończenie działania systemu");

    }
    public static void run(Direction[] args) {

        for (Direction arg : args) {
            if(arg==null){
                continue;
            }
            switch (arg) {
                case f -> System.out.print("Zwierzak idzie do przodu");
                case b -> System.out.print("Zwierzak idzie do tyłu");
                case l -> System.out.print("Zwierzak idzie w lewl ro");
                case r -> System.out.print("Zwierzak idzie w prawo");

            }
            System.out.println();
        }
    }
    public static Direction[] change(String args){
        Direction[] direction= new Direction[args.length()];
        int j =0;
        for (int i =0; i<args.length(); i++) {
            switch (args.charAt(i)) {
                case 'f' -> direction[j] = Direction.f;
                case 'b' -> direction[j] = Direction.b;
                case 'l' -> direction[j] = Direction.l;
                case 'r' -> direction[j] = Direction.r;
                default -> j--;
            }
            j++;
        }
        return direction;
    }
}
>>>>>>> f03ca5454e3754f7bb29ab8213e5c1819c14e578:pl/edu/agh/po/lab01/World.java
