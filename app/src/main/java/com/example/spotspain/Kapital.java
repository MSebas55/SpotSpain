package com.example.spotspain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Kapital extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapital);
    }
    public void VolveraBuscador() {
        Intent nIntent = new Intent(Kapital.this, SearchFragment.class);
        startActivity(nIntent);
    }
}