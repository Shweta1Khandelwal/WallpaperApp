package com.iskylar.shweta.wallpaperapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Shweta on 7/11/2017.
 */
public class DownloadImageGridViewAdapter extends RecyclerView.Adapter<DownloadImageGridViewAdapter.ViewHolder> implements View.OnClickListener{
    private Activity activity;
    private String[] filepath;
    private String[] filename;

    public DownloadImageGridViewAdapter(Activity activity, String[] filepath,String[] filename) {
        this.activity = activity;
        this.filepath = filepath;
        this.filename=filename;

    }


    @Override
    public DownloadImageGridViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.downlaod_image_recycler_item,parent,false);

        return  new DownloadImageGridViewAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DownloadImageGridViewAdapter.ViewHolder holder, final int position) {

        Bitmap bmp = BitmapFactory.decodeFile(filepath[position]);
        holder.img.setImageBitmap(bmp);
       holder.img.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View view) {

               AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
              /* alertDialog.setTitle("Delete");*/
LayoutInflater inflater=LayoutInflater.from(view.getContext());
View view1=inflater.inflate(R.layout.delpopup,null);
               alertDialog.setView(view1);
               alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
               alertDialog.show();
               alertDialog.setCancelable(true);
               Button btn= (Button) alertDialog.findViewById(R.id.del);
              btn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {



                  }
              });
              /* WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

               lp.copyFrom(alertDialog.getWindow().getAttributes());
               lp.width = 450;
               lp.height = 150;


               lp.x=-170;
               lp.y=100;
               alertDialog.getWindow().setAttributes(lp);*/
               return false;
           }
       });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, DownloadImageShow.class);
                // Pass String arrays FilePathStrings
                i.putExtra("filepath",filepath);
                // Pass String arrays FileNameStrings
              //  i.putExtra("filename", filename);
                // Pass click position
                i.putExtra("position", position);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filepath.length;
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder
{

    ImageView img;
    public ViewHolder(View itemView) {
        super(itemView);
        img= (ImageView) itemView.findViewById(R.id.Image_main);

        // Decode the filepath with BitmapFactory followed by the position

    }
}
}
