package com.example.barto.zajeciaandroidjeden;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {

    TextView displayCalendar;
    private DatePickerDialog.OnDateSetListener mDateListener;
    private static final int PICK_IMAGE=100;
    Uri imageUri;
    ImageView imageView;






    @Override
    protected void onCreate(Bundle savedInstanceBundle) {

        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.new_task_with_description);
        final TextView name = (TextView) findViewById(R.id.new_task_name);
        final TextView date = (TextView) findViewById(R.id.new_task_date);
        final TextView description = (TextView) findViewById(R.id.new_task_description);
        imageView=(ImageView) findViewById(R.id.imageFromGallery);



        /*
        if(getIntent().hasExtra("name")){
            name.setText(getIntent().getExtras().getString("name"));
        }
        if (getIntent().hasExtra("date")) {
            date.setText(getIntent().getExtras().getString("date"));
        }
        if (getIntent().hasExtra("description")) {
            description.setText(getIntent().getExtras().getString("description"));
        }

*/


        displayCalendar = (TextView) findViewById(R.id.new_task_date);
        displayCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(
                        AddTaskActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                displayCalendar.setText(date);
            }
        };










        Button addImage=(Button) findViewById(R.id.addImageButton);
        addImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openGallery();





            }
        });




        Button addTask=(Button) findViewById(R.id.new_task_button);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("description",description.getText().toString());
                intent.putExtra("date", date.getText().toString());
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });



    }


    private void openGallery()
    {

        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentData)
    {
        super.onActivityResult(requestCode,resultCode,intentData);
        if(resultCode==RESULT_OK&&requestCode==PICK_IMAGE)
        {
            imageUri=intentData.getData();
            imageView.setImageURI(imageUri);






        }


    }










}
