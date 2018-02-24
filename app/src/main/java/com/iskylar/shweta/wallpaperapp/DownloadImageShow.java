package com.iskylar.shweta.wallpaperapp;

import android.annotation.TargetApi;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class DownloadImageShow extends AppCompatActivity {
      ImageView imageview;
    Button btn;
    Bitmap bmp;
InputStream input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image_show);
        Intent i=getIntent();
        int position=i.getExtras().getInt("position");
        String[] filePath=i.getStringArrayExtra("filepath");


        imageview= (ImageView) findViewById(R.id.Download_image_show);
         bmp= BitmapFactory.decodeFile(filePath[position]);
        imageview.setImageBitmap(bmp);
        // now set image as phone wallpaper
/*btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
               WallpaperManager myWallpaperManager
                = WallpaperManager.getInstance(getApplicationContext());
        try {
             bmp=((BitmapDrawable)imageview.getDrawable()).getBitmap();
            if(bmp!=null)
                myWallpaperManager.setBitmap(bmp);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
});*/


}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menufile,menu);
        return  true;
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Main_Screen:
               /* Snackbar snackbar=Snackbar.make((View) item,"Set as wallpaper",Snackbar.LENGTH_LONG);
                snackbar.show();*/
                Toast.makeText(DownloadImageShow.this, "Set as wallpaper", Toast.LENGTH_LONG).show();
                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());
                try {
                    bmp=((BitmapDrawable)imageview.getDrawable()).getBitmap();
                    if(bmp!=null)
                        myWallpaperManager.setBitmap(bmp);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

break;
            case R.id.delete:
               /* Snackbar snackbar1=Snackbar.make((View) item,"Wallpaper Deleted",Snackbar.LENGTH_LONG);
                snackbar1.show();*/
                Toast.makeText(DownloadImageShow.this, "delete", Toast.LENGTH_LONG).show();
                imageview.setVisibility(View.GONE);


        }
        return super.onOptionsItemSelected(item);
    }
}
