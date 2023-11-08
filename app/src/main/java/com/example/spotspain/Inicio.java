package com.example.spotspain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.spotspain.Database.DatabaseAux;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        showElements();
    }
    public void changeToLogin(View view) {
        Intent intent = new Intent(Inicio.this, Login.class);
        startActivity(intent);
    }
    void showElements() {
        SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        LinearLayout layout = findViewById(R.id.fillContentShow);

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);

                TextView data = new TextView(this);
                Button b = new Button(this);
                data.setText("Nombre: " + name + " Email: " + email);

                b.setText("Eliminar Campo");
                data.getResources().getColor(R.color.white);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Toast.makeText(v.getContext(), name, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Inicio.this, Login.class);
                        intent.putExtra("message_key_name", name);
                        intent.putExtra("message_key_email", email);
                        startActivity(intent);

                    }
                });
                layout.addView(data);
                layout.addView(b);
            }while(cursor.moveToNext());
        }
        db.close();
    }
}