package agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d position = new Vector2d(1, 2);
        assertEquals("(1,2)", position.toString());
    }

    @Test
    void precedesLower() {
        Vector2d position1 = new Vector2d(1, 2);
        Vector2d position2 = new Vector2d(2, 3);
        assertTrue(position1.precedes(position2));
    }

    @Test
    void precedesEqual() {
        Vector2d position1 = new Vector2d(2, 3);
        Vector2d position2 = new Vector2d(2, 3);
        assertTrue(position1.precedes(position2));
    }

    @Test
    void precedesHigher() {
        Vector2d position1 = new Vector2d(3, 5);
        Vector2d position2 = new Vector2d(2, 3);
        assertFalse(position1.precedes(position2));
    }

    @Test
    void followsHigher() {
        Vector2d position1 = new Vector2d(2, 3);
        Vector2d position2 = new Vector2d(1, 1);
        assertTrue(position1.follows(position2));
    }

    @Test
    void followsLower() {
        Vector2d position1 = new Vector2d(1, 2);
        Vector2d position2 = new Vector2d(2, 3);
        assertFalse(position1.follows(position2));
    }

    @Test
    void followsEqual() {
        Vector2d position1 = new Vector2d(1, 2);
        Vector2d position2 = new Vector2d(1, 2);
        assertTrue(position1.follows(position2));
    }

    @Test
    void upperRight() {
        Vector2d position1 = new Vector2d(1, 4);
        Vector2d position2 = new Vector2d(2, 3);

        Vector2d position3 = new Vector2d(2, 4);
        assertEquals(position3, position1.upperRight(position2));

    }

    @Test
    void lowerLeft() {
        Vector2d position1 = new Vector2d(1, 4);
        Vector2d position2 = new Vector2d(2, 3);

        Vector2d position3 = new Vector2d(1, 3);
        assertEquals(position3, position1.lowerLeft(position2));
    }

    @Test
    void add() {
        Vector2d position1 = new Vector2d(1, 4);
        Vector2d position2 = new Vector2d(2, 3);

        Vector2d position3 = new Vector2d(3, 7);
        assertEquals(position3, position1.add(position2));
    }

    @Test
    void subtract() {
        Vector2d position1 = new Vector2d(1, 4);
        Vector2d position2 = new Vector2d(2, 3);

        Vector2d position3 = new Vector2d(-1, 1);
        assertEquals(position3, position1.subtract(position2));
    }

    @Test
    void testEquals() {
        Vector2d position1 = new Vector2d(1, 4);
        Vector2d position2 = new Vector2d(1, 4);
        assertEquals(position2, position1);
    }

    @Test
    void testNotEquals() {
        Vector2d position1 = new Vector2d(1, 4);
        Vector2d position2 = new Vector2d(1, 5);
        assertNotEquals(position2, position1);
    }

    @Test
    void opposite() {
        Vector2d position1 = new Vector2d(1, 4);
        Vector2d position2 = new Vector2d(-1, -4);
        assertEquals(position2, position1.opposite());
    }
}
