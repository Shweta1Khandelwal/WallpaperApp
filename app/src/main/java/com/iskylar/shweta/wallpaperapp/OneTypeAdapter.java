package com.iskylar.shweta.wallpaperapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.ArrayList;

/**
 * Created by Shweta on 7/22/2017.
 */
public class OneTypeAdapter extends RecyclerView.Adapter<OneTypeAdapter.DataObjectHolder> {
   private ArrayList<OneType_data> mDataset=new ArrayList<>();
     private Context context;
   OneType_data oneType_data;

    public OneTypeAdapter(ArrayList<OneType_data> mDataset,Context context) {
        this.mDataset = mDataset;
        this.context=context;
    }

    @Override
    public OneTypeAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_one_type,parent,false);
        DataObjectHolder dataObjectHolder=new DataObjectHolder(view,context,mDataset);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(OneTypeAdapter.DataObjectHolder holder,final int position) {
        oneType_data =mDataset.get(position);

       holder.img.setImageResource(oneType_data.getOneTypeImages());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // int position=context.getAdapterPosition();
              // Toast.makeText(context, ""+""+mDataset.get(position), Toast.LENGTH_SHORT).show();
                OneType_data one= mDataset.get(position);
                Intent intent=new Intent(context,SameTypeViewPagerActivity.class);
                intent.putExtra("img_id",one.getId());
                intent.putExtra("POSITION",position);//to put current position
                Toast.makeText(context, "id:"+one.getId(), Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return  mDataset.size();
    }
    public static class DataObjectHolder extends RecyclerView.ViewHolder{// implements View.OnClickListener {
        ImageView img;
        Context context;
        ArrayList<OneType_data> mDataset=new ArrayList<OneType_data>();

        public DataObjectHolder(View itemView, Context context, ArrayList<OneType_data> mDataset) {
            super(itemView);
           // itemView.setOnClickListener(this);
            this.mDataset=mDataset;
            this.context=context;
            img = (ImageView) itemView.findViewById(R.id.Images_One_Type);


        }
      /*  @Override
        public void onClick(View view) {
          *//*  int position=getAdapterPosition();
            Wallpaper_DataObject wallpaper= this.mDataset.get(position);
            Intent intent=new Intent(this.context,SameTypeViewPagerActivity.class);
            intent.putExtra("img_id:",wallpaper.getWallpaper_cardview_image());
            this.context.startActivity(intent);*//*

        }*/
    }

}
