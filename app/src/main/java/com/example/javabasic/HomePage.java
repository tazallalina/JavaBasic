package com.example.javabasic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.javabasic.PdfView.pdfName;

public class HomePage extends AppCompatActivity {

    Button theory,question,program;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        theory = findViewById(R.id.buttonTheory);

        theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowData.dataPath = "Theory";
                ShowData.topic = "Basic Theory";
                ShowData.dataDescriptionPath = "Theory Descriptions";
                startActivity(new Intent(HomePage.this,ShowData.class));
            }
        });


        question = findViewById(R.id.buttonQuestion);

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowData.dataPath = "Question";
                ShowData.topic = "Question";
                ShowData.dataDescriptionPath = "Question Descriptions";
                startActivity(new Intent(HomePage.this,ShowData.class));
            }
        });


        program = findViewById(R.id.buttonProgram);

        program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pdfName = "Basic_java_programs.pdf";
               Intent intent = new Intent(HomePage.this,PdfView.class);
               intent.putExtra("ViewType","assets");
               startActivity(intent);

            }
        });
    }
}
