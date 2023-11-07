package com.example.spotspain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spotspain.Database.DatabaseAux;

public class InsertToDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_to_db);
    }

    public void changeToMain(View view) {
        Intent nIntent = new Intent(InsertToDB.this, MainActivity.class);
        startActivity(nIntent);
    }

    public void insertValues(View v) {
        TextView nameTextView = findViewById(R.id.insertName);
        TextView emailTextView = findViewById(R.id.insertPass);
        TextView passTextView = findViewById(R.id.insertPass);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();
        String passString = emailTextView.getText().toString();

        DatabaseAux aux = new DatabaseAux(InsertToDB.this);
        SQLiteDatabase db = aux.getWritableDatabase();

        if(db != null && !nameString.isEmpty() && !emailString.isEmpty() && !passString.isEmpty()) {
            ContentValues values = new ContentValues();
            values.put("name", nameString);
            values.put("email", emailString);
            values.put("email", passString);

            long res = db.insert("TABLE_CUENTAS", null, values);
            if(res >= 0) {
                Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
                nameTextView.setText("");
                emailTextView.setText("");
                passTextView.setText("");
            }
            else {
                Toast.makeText(this, "Fallo al insertar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }

    }
}