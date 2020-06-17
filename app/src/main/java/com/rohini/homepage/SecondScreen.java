package com.rohini.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondScreen extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen2);
        imageView=findViewById(R.id.image);

        String id=getIntent().getStringExtra("id");

        String url="https://picsum.photos/300/300?image="+id;

        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_background).into(imageView);

    }
}
