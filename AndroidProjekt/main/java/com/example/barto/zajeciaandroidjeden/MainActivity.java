package com.example.barto.zajeciaandroidjeden;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.ArrayList;
import java.util.List;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private MyAdapter mAdapter;

    private List<BaseImageClass> baseImageClassList;


    private SharedPreferences preferences;
    String serializedTasks;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseImageClassList =new ArrayList<>();



        ///shared preferences zeby zapisywac sobie dane caly czas
        //wywala blad, ze lista jest pusta?????? debugger nie pomogl

       // Gson gson=new Gson();
       //preferences=this.getPreferences(Context.MODE_PRIVATE);
       //serializedTasks=preferences.getString("tasks","");
       //baseImageClassList=gson.fromJson(serializedTasks,new TypeToken<ArrayList<BaseImageClass>>(){}.getType());









        mRecyclerView=(RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter(baseImageClassList, mRecyclerView));
        mAdapter=new MyAdapter(baseImageClassList, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);




        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                baseImageClassList.remove(position);
                mAdapter.notifyDataSetChanged();
            }


            @Override
            public void onItemClick(int position)
            {
                Intent startIntent = new Intent(getApplicationContext(), DetailedStuff.class);
                startIntent.putExtra("name", baseImageClassList.get(position).getImageName());
                startIntent.putExtra("date", baseImageClassList.get(position).getExpirationDate());
                startIntent.putExtra("description", baseImageClassList.get(position).getImageDescription());
                startIntent.putExtra("image", baseImageClassList.get(position).getImageUri());

                startActivityForResult(startIntent, 1);


            }
        });





         Button newTaskButton = (Button) findViewById(R.id.newTaskButton);
        newTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                android.content.Intent startIntent = new android.content.Intent(getApplicationContext(), AddPhotoWithDescription.class);
                startActivityForResult(startIntent,1);
            }
        });




    }



    @Override
     protected void onPause() {

        super.onPause();



        ///////nie ma znaczenia bo wyżej zakomentowane

        super.onPause();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        serializedTasks = gson.toJson(baseImageClassList);
        preferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("tasks", serializedTasks);
        editor.apply();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentData)
    {






        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
                BaseImageClass task = new BaseImageClass();
                task.imageName = intentData.getStringExtra("name");
                task.imageDescription = intentData.getStringExtra("description");
                task.expirationDate = intentData.getStringExtra("date");
               // task.imageUri= intentData.getParcelableExtra("image");


                task.imageUri= Uri.parse(intentData.getStringExtra("image"));
                baseImageClassList.add(task);

                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }
        }


    }




}
