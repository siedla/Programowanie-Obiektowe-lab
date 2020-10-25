package agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    @Test
    void moveForward1() {
        Animal animal = new Animal();
        animal.move(MoveDirection.FORWARD);
        assertEquals("Animal{orientation=Północ, position=(2,3)}", animal.toString());
        animal.move(MoveDirection.FORWARD);
        assertEquals("Animal{orientation=Północ, position=(2,4)}", animal.toString());
        animal.move(MoveDirection.FORWARD);
        assertEquals("Animal{orientation=Północ, position=(2,4)}", animal.toString());
    }

    @Test
    void moveBackward() {
        Animal animal = new Animal();
        animal.move(MoveDirection.BACKWARD);
        assertEquals("Animal{orientation=Północ, position=(2,1)}", animal.toString());
        animal.move(MoveDirection.BACKWARD);
        assertEquals("Animal{orientation=Północ, position=(2,0)}", animal.toString());
        animal.move(MoveDirection.BACKWARD);
        assertEquals("Animal{orientation=Północ, position=(2,0)}", animal.toString());
    }

    @Test
    void moveLeft() {
        Animal animal = new Animal();
        animal.move(MoveDirection.LEFT);
        assertEquals("Animal{orientation=Zachód, position=(2,2)}", animal.toString());
        animal.move(MoveDirection.LEFT);
        assertEquals("Animal{orientation=Południe, position=(2,2)}", animal.toString());
        animal.move(MoveDirection.LEFT);
        assertEquals("Animal{orientation=Wschód, position=(2,2)}", animal.toString());
    }

    @Test
    void moveRight() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Wschód, position=(2,2)}", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Południe, position=(2,2)}", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Zachód, position=(2,2)}", animal.toString());
    }

    @Test
    void moveRightAndForward() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Wschód, position=(2,2)}", animal.toString());
        animal.move(MoveDirection.FORWARD);
        assertEquals("Animal{orientation=Wschód, position=(3,2)}", animal.toString());
        animal.move(MoveDirection.FORWARD);
        assertEquals("Animal{orientation=Wschód, position=(4,2)}", animal.toString());
        animal.move(MoveDirection.FORWARD);
        assertEquals("Animal{orientation=Wschód, position=(4,2)}", animal.toString());
    }

    @Test
    void moveLeftAndForward() {
        Animal animal = new Animal();
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Wschód, position=(2,2)}", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Południe, position=(2,2)}", animal.toString());
        animal.move(MoveDirection.RIGHT);
        assertEquals("Animal{orientation=Zachód, position=(2,2)}", animal.toString());
    }
}