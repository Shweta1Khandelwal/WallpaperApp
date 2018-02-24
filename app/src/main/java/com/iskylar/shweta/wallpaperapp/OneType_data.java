package com.iskylar.shweta.wallpaperapp;

/**
 * Created by Shweta on 7/23/2017.
 */
public class OneType_data {
    private int oneTypeImages;
    private int id;
//private int idSameType;

    public OneType_data(int oneTypeImages, int id) {
        this.oneTypeImages = oneTypeImages;
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public int getOneTypeImages() {
        return oneTypeImages;
    }


}
