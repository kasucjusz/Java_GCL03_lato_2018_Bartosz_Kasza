package com.example.barto.zajeciaandroidjeden;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedStuff extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_stuff);

        TextView name=(TextView) findViewById(R.id.detailedName);
        TextView date=(TextView)findViewById(R.id.detailedDate);
        TextView description=(TextView) findViewById(R.id.detaildedDescription);
        ImageView detailedImage=(ImageView) findViewById(R.id.detailedImage);


        //przyjmujemy tu na klate rzeczy z mainActivity

        if(getIntent().hasExtra("name"))
        {
            name.setText(getIntent().getExtras().getString("name"));


        }
        if(getIntent().hasExtra("date"))
        {
            date.setText(getIntent().getExtras().getString("date"));


        }
        if(getIntent().hasExtra("description"))
        {
            description.setText(getIntent().getExtras().getString("description"));


        }

        if(getIntent().hasExtra("image"))
        {


            detailedImage.setImageURI(Uri.parse(getIntent().getExtras().getString("image")));

            //detailedImage.setImageURI(Uri.parse(getIntent().getExtras().getString("image")));


        }



    }
}
