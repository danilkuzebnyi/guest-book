package task1;

public enum Direction {
    ASC(1), DESC(-1);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return this.direction;
    }
}

