package com.example.javabasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.javabasic.ShowData.description;
import static com.example.javabasic.ShowData.title;

public class showDescription extends AppCompatActivity {


    TextView showTitle,showDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_description);

        showDescription = findViewById(R.id.topic_description);
        showTitle = findViewById(R.id.topic_title);
        showTitle.setText(title+":");
        showDescription.setText(description);
    }
}
