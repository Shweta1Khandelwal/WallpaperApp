package com.iskylar.shweta.wallpaperapp;

import android.widget.ImageView;

/**
 * Created by Shweta on 7/18/2017.
 */
public class Wallpaper_DataObject {
    private String Wallpaper_cardview_text;
    private int Wallpaper_cardview_image;
private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWallpaper_cardview_text() {
        return Wallpaper_cardview_text;
    }

    public void setWallpaper_cardview_text(String wallpaper_cardview_text) {
        Wallpaper_cardview_text = wallpaper_cardview_text;
    }

    public int getWallpaper_cardview_image() {
        return Wallpaper_cardview_image;
    }

    public void setWallpaper_cardview_image(int wallpaper_cardview_image) {
        Wallpaper_cardview_image = wallpaper_cardview_image;
    }
}
