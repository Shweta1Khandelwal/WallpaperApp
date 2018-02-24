package com.iskylar.shweta.wallpaperapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class OneType extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ImageView imageView;
    private RecyclerView.LayoutManager mLayoutManager;
   /*private final int IDsameType[]={
           1,2,3,4,5,6
   };*/
    private final int IDOneType[]={
            1,1,1,1,1,1,
            2,2,2,2,2,2,
            3,3,3,3,3,3,
            4,4,4,4,4,4,
            5,5,5,5,5,5,
            6,6,6,6,6,6

    };
    private final int OneTypeImagesArray[] = {
            R.drawable.nature11,R.drawable.nature1,R.drawable.nature5,R.drawable.nature2,R.drawable.nature3, R.drawable.nature6,
            R.drawable.bird2,R.drawable.bird3,R.drawable.bird4,R.drawable.bird5,R.drawable.bird1,R.drawable.bird6,
            R.drawable.star2,R.drawable.star1,R.drawable.star3,R.drawable.star4,R.drawable.star5,R.drawable.star6,
            R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,R.drawable.cat4,R.drawable.cat5,R.drawable.cat6,
            R.drawable.ghost1,R.drawable.ghost2,R.drawable.ghost3,R.drawable.ghost,R.drawable.ghost5,R.drawable.ghost6,
            R.drawable.love1, R.drawable.love2, R.drawable.love3, R.drawable.love4, R.drawable.love5, R.drawable.love6
              };


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_type);
        intent = getIntent();

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_OneType);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new GridLayoutManager(OneType.this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter=new OneTypeAdapter(prepareData(),OneType.this);

        mRecyclerView.setAdapter(mAdapter);
        imageView= (ImageView) findViewById(R.id.Images_One_Type);
       /* imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(OneType.this,SameTypeViewPagerActivity.class);
                startActivity(i);
            }
        });
        Intent intent=new Intent(OneType.this,SameTypeViewPagerActivity.class);
        startActivity(intent);*/
    }
    private ArrayList<OneType_data> prepareData(){
        ArrayList<OneType_data> objects=new ArrayList<>();
        int imgaeid = intent.getIntExtra("id",0);
        for(int i=0;i<IDOneType.length;i++){
            int id = IDOneType[i];
            if(id == imgaeid) {
                objects.add(new OneType_data(OneTypeImagesArray[i],id));

            }
                   }
        return objects;
            }
    }

