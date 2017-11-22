package com.example.szilsan.model;

/**
 * Created by szilsan on 11/07/2017.
 */
public class Globe {

    private Coordinate position;
    private Coordinate currentSpeed;

    private double mass;

    public Globe(double x, double y, double z) {
        this.position = new Coordinate(x, y, z);
    }

    public Globe(double x, double y, double z, double mass) {
        this.position = new Coordinate(x, y, z);
        this.mass = mass;
    }

    public Globe(Coordinate position, double mass) {
        this.position = position;
        this.mass = mass;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Coordinate getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(Coordinate currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
