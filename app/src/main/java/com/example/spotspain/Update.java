package com.example.spotspain;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent currentIntent = getIntent();
        TextView u = findViewById(R.id.updateName);
        u.setText(currentIntent.getStringExtra("message_key"));
    }
}