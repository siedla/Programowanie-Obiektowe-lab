/*package agh.cs.lab2;

import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void main() {
        Animal animal = new Animal();
        String[] moves = {"f", "forward", "f"};
        LinkedList<MoveDirection> moves2 = OptionsParser.parse(moves);
        for(MoveDirection move : moves2){ // sprawdzam czy dobrze interpretuje napisy w tablicy i nie wychodzi z mapy od góry
            animal.move(move);
        }
        assertEquals("Animal{orientation=Północ, position=(2,4)}", animal.toString()); //sprawdzam czy nie wychodzi za mape z prawej strony
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals("Animal{orientation=Wschód, position=(4,4)}", animal.toString());
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);

        for(int i=0; i<4; i++)
            animal.move(MoveDirection.FORWARD);

        assertEquals("Animal{orientation=Zachód, position=(0,4)}", animal.toString()); // czy dobrze sie obraca i nie wychodzi od lewej
        animal.move(MoveDirection.RIGHT);

        for(int i=0; i<4; i++)
            animal.move(MoveDirection.BACKWARD); // czy dobrze sie obraca w prawo i idzie do tyłu

        assertEquals("Animal{orientation=Północ, position=(0,0)}", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Wschód, position=(0,0)}", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Południe, position=(0,0)}", animal.toString());
    }


}*/