package com.example.spotspain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spotspain.Database.DatabaseAux;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView titulo = findViewById(R.id.titulo);

        Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        titulo.startAnimation(zoomAnimation);

    }
    public void changeToInicio(View view) {
        Intent intent = new Intent(Register.this, Inicio.class);
        startActivity(intent);
    }
    public void insertValues(View v) {

        TextView nameTextView = findViewById(R.id.usuarioreg);
        TextView emailTextView = findViewById(R.id.mailreg);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();

        DatabaseAux aux = new DatabaseAux(Register.this);
        SQLiteDatabase db = aux.getWritableDatabase();

        if(db != null && !nameString.isEmpty() && !emailString.isEmpty()) {
            ContentValues values = new ContentValues();
            values.put("name", nameString);
            values.put("email", emailString);

            long res = db.insert("users", null, values);
            if(res >= 0) {
                Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
                nameTextView.setText("");
                emailTextView.setText("");
            }
            else {
                Toast.makeText(this, "Fallo al insertar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }
        Intent nIntent = new Intent(Register.this, Login.class);
        startActivity(nIntent);
    }
}