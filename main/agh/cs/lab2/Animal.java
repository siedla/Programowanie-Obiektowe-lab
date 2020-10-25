package agh.cs.lab2;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    @Override
    public String toString() {
        return "Animal{" +
                "orientation=" + orientation +
                ", position=" + position +
                '}';
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                switch (orientation){
                    case NORTH -> {
                        if (position.y < 4)
                            position = position.add(MapDirection.NORTH.toUnitVector());
                    }
                    case EAST -> {
                        if(position.x < 4)
                            position = position.add(MapDirection.EAST.toUnitVector());
                    }
                    case SOUTH -> {
                        if(position.y > 0)
                            position = position.add(MapDirection.SOUTH.toUnitVector());
                    }
                    case WEST -> {
                        if (position.x > 0)
                            position = position.add(MapDirection.WEST.toUnitVector());
                    }
                }
            }
            case BACKWARD -> {
                switch (orientation){
                    case NORTH -> {
                        if (position.y > 0)
                            position = position.subtract(MapDirection.NORTH.toUnitVector());
                    }
                    case EAST -> {
                        if(position.x > 0)
                            position = position.subtract(MapDirection.EAST.toUnitVector());
                    }
                    case SOUTH -> {
                        if(position.y < 4)
                            position = position.subtract(MapDirection.SOUTH.toUnitVector());
                    }
                    case WEST -> {
                        if (position.x < 4)
                            position = position.subtract(MapDirection.WEST.toUnitVector());
                    }
                }

            }
        }

    }

}
