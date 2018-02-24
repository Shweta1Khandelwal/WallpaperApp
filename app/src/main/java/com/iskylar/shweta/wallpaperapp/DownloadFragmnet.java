package com.iskylar.shweta.wallpaperapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.List;


public class DownloadFragmnet extends Fragment implements View.OnClickListener{
    private String[] FilePathStrings;
    private String[] FileNameStrings;
    private File[] listFile;
    RecyclerView recyclerView;
    RecyclerView.Adapter listAdapter;
    RecyclerView.LayoutManager layoutManager;
    File file;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_download_fragmnet, container, false);
// Check for SD Card
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Toast.makeText(getActivity(), "Error! No SDCARD Found!", Toast.LENGTH_LONG)
                    .show();
        } else {
            // Locate the image folder in your SD Card
            file = new File(Environment.getExternalStorageDirectory()
                    + File.separator + "SaveImage");
            // Create a new folder if no folder named SDImageTutorial exist
            file.mkdirs();
        }

        if (file.isDirectory()) {
            listFile = file.listFiles();
            // Create a String array for FilePathStrings
            FilePathStrings = new String[listFile.length];
            // Create a String array for FileNameStrings
            FileNameStrings = new String[listFile.length];

            for (int i = 0; i < listFile.length; i++) {
                // Get the path of the image file
                FilePathStrings[i] = listFile[i].getAbsolutePath();
                // Get the name image file
                FileNameStrings[i] = listFile[i].getName();
            }
        }
        recyclerView= (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        listAdapter = new DownloadImageGridViewAdapter(getActivity(), FilePathStrings, FileNameStrings);

        recyclerView.setAdapter(listAdapter);
      /*  imageView= (ImageView) view.findViewById(R.id.Image_main);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        Toast.makeText(getActivity(), "yes", Toast.LENGTH_SHORT).show();
        return true;
    }
});*/
        return view;

    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(getActivity(), DownloadImageShow.class);
        // Pass String arrays FilePathStrings
        i.putExtra("filepath", FilePathStrings);
        // Pass String arrays FileNameStrings
        i.putExtra("filename", FileNameStrings);
        // Pass click position
       // i.putExtra("position", position);
        startActivity(i);
    }
}
