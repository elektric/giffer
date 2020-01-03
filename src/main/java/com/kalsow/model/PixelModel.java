package com.kalsow.model;

public class PixelModel {

    private int r;
    private int b;
    private int g;
    private int a;
    private int rowLoc;
    private int colLoc;

    public PixelModel(int red, int green, int blue, int alpha, int rowLoc, int colLoc) {
        super();
        this.r = red;
        this.b = blue;
        this.g = green;
        this.a = alpha;
        this.rowLoc = rowLoc;
        this.colLoc = colLoc;
    }

    public PixelModel() {
        
    }

    public int getRed() {
        return r;
    }

    public void setRed(int red) {
        this.r = red;
    }

    public int getBlue() {
        return b;
    }

    public void setBlue(int blue) {
        this.b = blue;
    }

    public int getGreen() {
        return g;
    }

    public void setGreen(int green) {
        this.g = green;
    }

    public int getAlpha() {
        return a;
    }

    public void setAlpha(int alpha) {
        this.a = alpha;
    }

    public int getRowLoc() {
        return rowLoc;
    }

    public void setRowLoc(int rowLoc) {
        this.rowLoc = rowLoc;
    }

    public int getColLoc() {
        return colLoc;
    }

    public void setColLoc(int colLoc) {
        this.colLoc = colLoc;
    }

    
}
