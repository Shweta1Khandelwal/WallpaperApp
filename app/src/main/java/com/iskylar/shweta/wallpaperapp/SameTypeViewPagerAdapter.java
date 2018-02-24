package com.iskylar.shweta.wallpaperapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Shweta on 7/22/2017.
 */
public class SameTypeViewPagerAdapter extends PagerAdapter {
    Activity context;
    ArrayList<SameTypeData> objects=new ArrayList<>();
    LayoutInflater layoutInflater;
    ViewPager viewPager;
    SameTypeData sameTypeData;
   // ImageButton imageButton;
    public SameTypeViewPagerAdapter(Activity context, ArrayList objects) {
        this.context = context;
        this.objects = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = layoutInflater.inflate(R.layout.layout_sametype_viewpager, container, false);
        sameTypeData=objects.get(position);
        viewPager= (ViewPager) view.findViewById(R.id.pager);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageSameType);
        ImageButton imageButton= (ImageButton) view.findViewById(R.id.Download_ImageButton);
        imageView.setImageResource(sameTypeData.getImageSameType());
        Log.e("hello",sameTypeData.getImageSameType()+"");

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar=Snackbar.make(view,"Wallpaper Downloaded",Snackbar.LENGTH_LONG);
                snackbar.show();
                ActivityCompat.requestPermissions(context,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "Image_" + timeStamp + "_";
                Bitmap image= BitmapFactory.decodeResource(context.getResources(),sameTypeData.getImageSameType());
                //path to sd card
                File filepath = Environment.getExternalStorageDirectory();
                //create a folder
                File dir=new File(filepath.getAbsolutePath()+"/SaveImage");
                dir.mkdirs();
                File file=new File(dir,imageFileName+".png");
                OutputStream out=null;
                try {
                    out =new FileOutputStream(file);
                    image.compress(Bitmap.CompressFormat.PNG,100,out);
                    out.flush();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }




            }
        });
       /* imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions((Activity)context,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
               *//* int currentItem =viewPager.getCurrentItem();
                Drawable drawable = getResource.getDrawable(images[currentItem]);
                Bitmap bm =((BitmapDrawable) drawable).getBitmap();*//*
                OutputStream outputStream;
                Bitmap image= BitmapFactory.decodeResource(context.getResources(),R.drawable.bird1);
                Log.e("imgeeee",sameTypeData.getImageSameType()+"");
                //path to sd card
                File filepath = Environment.getExternalStorageDirectory();
                //create a folder
                File dir=new File(filepath.getAbsolutePath()+"Wallpaper");
                dir.mkdirs();
                File file=new File(dir,"wallpaper.png");
                OutputStream out=null;
                try {
                    out =new FileOutputStream(file);
                    image.compress(Bitmap.CompressFormat.PNG,100,out);
                    out.flush();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Snackbar snackbar=Snackbar.make(view,"Wallpaper Downloaded",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });*/
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
