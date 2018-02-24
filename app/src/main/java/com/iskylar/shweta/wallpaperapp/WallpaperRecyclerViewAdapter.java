package com.iskylar.shweta.wallpaperapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

/**
 * Created by Shweta on 7/18/2017.
 */
public class WallpaperRecyclerViewAdapter extends RecyclerView.Adapter<WallpaperRecyclerViewAdapter.DataObjectHolder>{
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Wallpaper_DataObject> mDataset;

   private AppCompatActivity activity;
    Context ctx;

       public WallpaperRecyclerViewAdapter(AppCompatActivity activity, ArrayList<Wallpaper_DataObject> mDataset,Context ctx) {
        this.mDataset = mDataset;
        this.activity = activity;
           this.ctx=ctx;

    }




    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_wallpaper,parent,false);
        DataObjectHolder dataObjectHolder=new DataObjectHolder(view,ctx,mDataset);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder,final int position) {
      final Wallpaper_DataObject wallpaper=this.mDataset.get(position);
       holder.img.setImageResource(mDataset.get(position).getWallpaper_cardview_image());
        holder.text.setText(mDataset.get(position).getWallpaper_cardview_text());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(ctx,OneType.class);
                i.putExtra("id",wallpaper.getId());
                ctx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
      return  mDataset.size();
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder{// implements View.OnClickListener {
        ImageView img;
        TextView text;
        Context ctx;
ArrayList<Wallpaper_DataObject> mDataset=new ArrayList<Wallpaper_DataObject>();

        public DataObjectHolder(View itemView, Context ctx, ArrayList<Wallpaper_DataObject> mDataset) {
            super(itemView);
           // itemView.setOnClickListener(this);
           this.mDataset=mDataset;
            this.ctx=ctx;
            img = (ImageView) itemView.findViewById(R.id.wallpaper_cardview_image);
           text = (TextView) itemView.findViewById(R.id.wallpaper_cardview_text);

        }

    }

}
