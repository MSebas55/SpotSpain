package com.example.spotspain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Button buttonTest = findViewById(R.id.buttonTest);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "hOLAAAAAA", Toast.LENGTH_LONG).show();
            }
        });*/
    }


    public void changeToInsert(View view) {
        Intent nIntent = new Intent(MainActivity.this, InsertToDB.class);
        startActivity(nIntent);
    }

    public void changeToDelete(View view) {
        Intent nIntent = new Intent(MainActivity.this, Delete.class);
        startActivity(nIntent);
    }

    public void changeToShow(View view) {
        Intent nIntent = new Intent(MainActivity.this, Show.class);
        startActivity(nIntent);
    }

}