package com.mhyhre.zone_1024.touch;

public class TouchPoint {
    final private float x, y;

    public TouchPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}