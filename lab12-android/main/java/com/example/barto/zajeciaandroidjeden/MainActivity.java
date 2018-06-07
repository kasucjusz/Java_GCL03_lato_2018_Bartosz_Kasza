package com.example.barto.zajeciaandroidjeden;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import com.google.gson.reflect.TypeToken;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private MyAdapter mAdapter;

    private List<Tasks> tasksList;


    private SharedPreferences preferences;
    String serializedTasks;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksList=new ArrayList<>();
        Tasks probny =new Tasks("robienie kupy", "heher mlody g trendsetter", "01.02.2018");
        tasksList.add(probny);

        ///shared preferences zeby zapisywac sobie dane caly czas

       // Gson gson=new Gson();
       //preferences=this.getPreferences(Context.MODE_PRIVATE);
       //serializedTasks=preferences.getString("tasks","");
       //tasksList=gson.fromJson(serializedTasks,new TypeToken<ArrayList<Tasks>>(){}.getType());









        mRecyclerView=(RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new MyAdapter(tasksList, mRecyclerView));
        mAdapter=new MyAdapter(tasksList, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);




        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                tasksList.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });




        //co sie dzieje po przycisniecu new task button

         Button newTaskButton = (Button) findViewById(R.id.newTaskButton);
        newTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                android.content.Intent startIntent = new android.content.Intent(getApplicationContext(), AddTaskActivity.class);
                startActivityForResult(startIntent,1);
            }
        });




    }



    @Override
     protected void onPause() {

        super.onPause();


        /*
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tasksList);
        editor.putString("tasks", json);
        editor.apply();
        */

        super.onPause();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        serializedTasks = gson.toJson(tasksList);
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
                Tasks task = new Tasks();
                task.taskName = intentData.getStringExtra("name");
                task.taskDescription = intentData.getStringExtra("description");
                task.expirationDate = intentData.getStringExtra("date");
                tasksList.add(task);

                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }
        }


    }




}
