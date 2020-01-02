package com.kalsow.model;

import java.util.ArrayList;
import java.util.List;

public class GifModel {
    public GifModel() {
        this.frameModelList = new ArrayList<>();
    }

    private List<FrameModel> frameModelList;

    public List<FrameModel> getFrameModelList() {
        return frameModelList;
    }

    public void setFrameModelList(List<FrameModel> frameModelList) {
        this.frameModelList = frameModelList;
    }
    
    public void addFrameModelToList(FrameModel frameModel) {
        this.frameModelList.add(frameModel);
    }


}
