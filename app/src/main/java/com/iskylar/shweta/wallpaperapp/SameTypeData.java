package com.iskylar.shweta.wallpaperapp;

/**
 * Created by Shweta on 7/24/2017.
 */
public class SameTypeData {
    private int idSameType;
    private int ImageSameType;

    public SameTypeData(int idSameType,int imageSameType) {
        this.ImageSameType=imageSameType;
        this.idSameType=idSameType;

    }

    public int getIdSameType() {
        return idSameType;
    }


    public int getImageSameType() {
        return ImageSameType;
    }

}
