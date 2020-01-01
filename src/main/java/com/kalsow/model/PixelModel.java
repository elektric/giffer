package com.kalsow.model;

public class PixelModel {

    private int red;
    private int blue;
    private int green;
    private int alpha;
    private int x;
    private int y;
    
    public PixelModel(int red, int blue, int green, int alpha, int x, int y) {
        super();
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.alpha = alpha;
        this.x = x;
        this.y = y;
    }
    
    public int getRed() {
        return red;
    }
    public void setRed(int red) {
        this.red = red;
    }
    public int getBlue() {
        return blue;
    }
    public void setBlue(int blue) {
        this.blue = blue;
    }
    public int getGreen() {
        return green;
    }
    public void setGreen(int green) {
        this.green = green;
    }
    public int getAlpha() {
        return alpha;
    }
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
