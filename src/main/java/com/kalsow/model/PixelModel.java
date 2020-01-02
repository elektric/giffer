package com.kalsow.model;

public class PixelModel {

    private int red;
    private int blue;
    private int green;
    private int alpha;
    private int rowLoc;
    private int colLoc;

    public PixelModel(int red, int green, int blue, int alpha, int rowLoc, int colLoc) {
        super();
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.alpha = alpha;
        this.rowLoc = rowLoc;
        this.colLoc = colLoc;
    }

    public PixelModel() {
        
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
