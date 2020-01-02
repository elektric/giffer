package com.kalsow.model;

import java.util.ArrayList;
import java.util.List;

public class FrameModel {

    public FrameModel() {
        this.pixelModelList = new ArrayList<>();
    }
    private List<PixelModel> pixelModelList;
    private int frameNumber;
    private int delay;

    public List<PixelModel> getPixelModelList() {
        return pixelModelList;
    }

    public void setPixelModelList(List<PixelModel> pixelModelList) {
        this.pixelModelList = pixelModelList;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
