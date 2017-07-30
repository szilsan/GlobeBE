package com.example.szilsan.model;

/**
 * Created by szilsan on 11/07/2017.
 */
public class Globe {
    private double x;
    private double y;
    private double z;

    private double mass;

    private double vx;
    private double vy;
    private double vz;

    public Globe(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Globe(double x, double y, double z, double mass) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = mass;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getVz() {
        return vz;
    }

    public void setVz(double vz) {
        this.vz = vz;
    }
}
