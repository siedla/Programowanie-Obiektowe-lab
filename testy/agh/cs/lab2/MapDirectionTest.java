<<<<<<< HEAD
package agh.cs.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        //given
        MapDirection direction1 = MapDirection.NORTH;
        MapDirection direction2 = MapDirection.EAST;
        MapDirection direction3 = MapDirection.SOUTH;
        MapDirection direction4 = MapDirection.WEST;
        //when
        direction1 = direction1.next();
        direction2 = direction2.next();
        direction3 = direction3.next();
        direction4 = direction4.next();
        //then
        Assertions.assertEquals(MapDirection.EAST, direction1);
        Assertions.assertEquals(MapDirection.SOUTH, direction2);
        Assertions.assertEquals(MapDirection.WEST, direction3);
        Assertions.assertEquals(MapDirection.NORTH, direction4);
    }
    @Test
    void previous() {
        //given
        MapDirection direction1 = MapDirection.NORTH;
        MapDirection direction2 = MapDirection.EAST;
        MapDirection direction3 = MapDirection.SOUTH;
        MapDirection direction4 = MapDirection.WEST;
        //when
        direction1 = direction1.previous();
        direction2 = direction2.previous();
        direction3 = direction3.previous();
        direction4 = direction4.previous();
        //then
        Assertions.assertEquals(MapDirection.WEST, direction1);
        Assertions.assertEquals(MapDirection.NORTH, direction2);
        Assertions.assertEquals(MapDirection.EAST, direction3);
        Assertions.assertEquals(MapDirection.SOUTH, direction4);
    }

    @Test
    void name() {
    }
=======
package agh.cs.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next() {
        //given
        MapDirection direction1 = MapDirection.NORTH;
        MapDirection direction2 = MapDirection.EAST;
        MapDirection direction3 = MapDirection.SOUTH;
        MapDirection direction4 = MapDirection.WEST;
        //when
        direction1 = direction1.next();
        direction2 = direction2.next();
        direction3 = direction3.next();
        direction4 = direction4.next();
        //then
        Assertions.assertEquals(MapDirection.EAST, direction1);
        Assertions.assertEquals(MapDirection.SOUTH, direction2);
        Assertions.assertEquals(MapDirection.WEST, direction3);
        Assertions.assertEquals(MapDirection.NORTH, direction4);
    }
    @Test
    void previous() {
        //given
        MapDirection direction1 = MapDirection.NORTH;
        MapDirection direction2 = MapDirection.EAST;
        MapDirection direction3 = MapDirection.SOUTH;
        MapDirection direction4 = MapDirection.WEST;
        //when
        direction1 = direction1.previous();
        direction2 = direction2.previous();
        direction3 = direction3.previous();
        direction4 = direction4.previous();
        //then
        Assertions.assertEquals(MapDirection.WEST, direction1);
        Assertions.assertEquals(MapDirection.NORTH, direction2);
        Assertions.assertEquals(MapDirection.EAST, direction3);
        Assertions.assertEquals(MapDirection.SOUTH, direction4);
    }
>>>>>>> f03ca5454e3754f7bb29ab8213e5c1819c14e578
}