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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
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
