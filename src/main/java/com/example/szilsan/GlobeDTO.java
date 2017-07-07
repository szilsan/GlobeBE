package com.example.szilsan;

/**
 * Created by szilsan on 06/07/2017.
 */

public class GlobeDTO {
    private double x;
    private double y;
    private double z;
    private double size;

    public GlobeDTO() {

    }

    public GlobeDTO(double x, double y, double z, double size) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
