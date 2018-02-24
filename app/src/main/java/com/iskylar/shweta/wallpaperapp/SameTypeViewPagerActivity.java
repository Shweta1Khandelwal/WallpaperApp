package com.iskylar.shweta.wallpaperapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

public class SameTypeViewPagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    ImageButton imageButton;
    private final int IDSameTypePager[]={

            1,1,1,1,1,1,
            2,2,2,2,2,2,
            3,3,3,3,3,3,
            4,4,4,4,4,4,
            5,5,5,5,5,5,
            6,6,6,6,6,6

    };
  public  int images[]={
            R.drawable.nature11,R.drawable.nature1,R.drawable.nature5,R.drawable.nature2,R.drawable.nature3, R.drawable.nature6,
            R.drawable.bird2,R.drawable.bird3,R.drawable.bird4,R.drawable.bird5,R.drawable.bird1,R.drawable.bird6,
            R.drawable.star2,R.drawable.star1,R.drawable.star3,R.drawable.star4,R.drawable.star5,R.drawable.star6,
            R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,R.drawable.cat4,R.drawable.cat5,R.drawable.cat6,
            R.drawable.ghost1,R.drawable.ghost2,R.drawable.ghost3,R.drawable.ghost,R.drawable.ghost5,R.drawable.ghost6,
            R.drawable.love1, R.drawable.love2, R.drawable.love3, R.drawable.love4, R.drawable.love5, R.drawable.love6
           };
   SameTypeViewPagerAdapter sameTypeViewPagerAdapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_type_view_pager);
        viewPager= (ViewPager) findViewById(R.id.pager);

        intent=getIntent();
        final ArrayList<SameTypeData> objects=new ArrayList<>();
        int imageid=intent.getIntExtra("img_id",0);
        final int pos = intent.getIntExtra("POSITION",0);//to get current position
        Log.e("ImagePostion", String.valueOf(pos));
        for(int i=0;i<IDSameTypePager.length;i++){
            int id=IDSameTypePager[i];
            if(id==imageid){
                objects.add( new SameTypeData(id,images[i]));
            }
        }
        sameTypeViewPagerAdapter =new SameTypeViewPagerAdapter(SameTypeViewPagerActivity.this, objects);
        viewPager.setAdapter(sameTypeViewPagerAdapter);
        viewPager.setCurrentItem(pos);//to get current position image
        Log.e("Imagee","Image");

    }
   /* public static boolean canWriteOnExternalStorage() {
        // get the state of your external storage
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // if storage is mounted return true
            Log.e("Folder","can write folder");
            return true;
        }
        return false;
    }
*/
}
