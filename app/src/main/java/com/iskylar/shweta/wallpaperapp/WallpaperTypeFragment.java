package com.iskylar.shweta.wallpaperapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


public class WallpaperTypeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;
    private  final int IDArray[]={
      1,2,3,4,5,6
    };
    private final String WallpaperText[]={
            "Nature",
            "Birds",
            "Star",
            "Cat1",
            "Ghost",
            "Love",

    };
private final int WallpaperImages[]={
        R.drawable.nature11,
        R.drawable.bird2,
    R.drawable.star2,
R.drawable.cat1,
        R.drawable.ghost1,
        R.drawable.love1,

};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_wallpaper_type, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.Wallpaper_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new WallpaperRecyclerViewAdapter((AppCompatActivity) getActivity(),prepareData(),getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
    private ArrayList<Wallpaper_DataObject> prepareData(){
        ArrayList<Wallpaper_DataObject> Objects=new ArrayList<>();
        for(int i=0;i<WallpaperText.length;i++){
            Wallpaper_DataObject wallpaper_dataObject=new Wallpaper_DataObject();
            wallpaper_dataObject.setId(IDArray[i]);
            wallpaper_dataObject.setWallpaper_cardview_image(WallpaperImages[i]);
            wallpaper_dataObject.setWallpaper_cardview_text(WallpaperText[i]);
            Objects.add(wallpaper_dataObject);
        }
        return Objects;
    }


}
