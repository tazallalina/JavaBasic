package com.example.javabasic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ListView listView;
    ArrayList<String> item;
    public static String title = "",description = "";


    public static String dataPath,dataDescriptionPath,topic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);




        listView = findViewById(R.id.theoryRec);
        item = new ArrayList<>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                title = listView.getItemAtPosition(position).toString();
                description =  listView.getItemAtPosition(position).toString();

                Toast.makeText(ShowData.this, ""+position, Toast.LENGTH_SHORT).show();

                display(position+1);
            }
        });

        TextView title = findViewById(R.id.title);
        title.setText(topic);
        SpannableString content = new SpannableString(title.getText().toString());
        content.setSpan(new UnderlineSpan(), 0, title.getText().toString().length(), 0);
        title.setText(content);


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(dataPath);
        databaseReference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot parent : dataSnapshot.getChildren()) {

                    item.add(parent.getValue().toString());

                }

                show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    void show(){
        ArrayAdapter adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,item);
        listView.setAdapter(adapter);
    }

    void display(int position){
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(dataDescriptionPath);

        databaseReference.child(""+position).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                description = dataSnapshot.getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        startActivity(new Intent(ShowData.this,showDescription.class));
    }

}
