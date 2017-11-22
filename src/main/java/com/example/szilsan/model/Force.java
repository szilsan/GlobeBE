package com.example.szilsan.model;

public class Force {
    private Coordinate coordinate;

    public Force(double x, double y, double z) {
        coordinate = new Coordinate(x, y, z);
    }

    public Force(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getSize() {
        return coordinate.getVectorSize();
    }

    @Override
    public String toString() {
        return "Force{" +
                "coordinate=" + coordinate +
                ", size=" + getSize() +
                '}';
    }
}
