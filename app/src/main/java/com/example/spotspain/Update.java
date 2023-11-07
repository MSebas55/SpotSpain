package com.example.spotspain;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spotspain.Database.DatabaseAux;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        showElements();
    }
//    void showElements() {
//        SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM db", null);
//        TextView view_nombre = findViewById(R.id.viewNombre);
//        TextView view_email = findViewById(R.id.viewEmail);
//        TextView view_pass = findViewById(R.id.viewContraseña);
//
////        if(cursor.moveToFirst()) {
////            do {
////                int id = cursor.getInt(0);
////                String name = cursor.getString(1);
////                String email = cursor.getString(2);
////                String pass = cursor.getString(3);
////
////                TextView data = new TextView(this);
////
////
////                view_nombre.append(name);
////                view_email.append(email);
////                view_pass.append(pass);
////            }while(cursor.moveToNext());
////        }        db.close();
////}

        void showElements() {
            SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM db", null);
            TextView view_nombre = findViewById(R.id.viewNombre);
            TextView view_email = findViewById(R.id.viewEmail);
            TextView view_pass = findViewById(R.id.viewContraseña);

            StringBuilder dataToShow = new StringBuilder();

            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String email = cursor.getString(2);
                    String pass = cursor.getString(3);

                    // Formatear los datos antes de mostrarlos
                    String formattedData = "ID: " + id + "\n" +
                            "Nombre: " + name + "\n" +
                            "Email: " + email + "\n" +
                            "Contraseña: " + pass + "\n\n";

                    dataToShow.append(formattedData);
                } while (cursor.moveToNext());

                // Mostrar los datos formateados en los TextViews
                view_nombre.setText(dataToShow.toString());
                view_email.setText("");  // Limpiar TextView antes de añadir nuevo contenido
                view_pass.setText("");
            }

            cursor.close();
            db.close();
        }
        void showPersonDetails(int personId) {
            SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

            // Realizar la consulta SQL para obtener los datos de una persona específica
            Cursor cursor = db.rawQuery("SELECT * FROM db WHERE id = ?", new String[]{String.valueOf(personId)});

            TextView view_nombre = findViewById(R.id.viewNombre);
            TextView view_email = findViewById(R.id.viewEmail);
            TextView view_pass = findViewById(R.id.viewContraseña);

            if (cursor.moveToFirst()) {
                // Obtener los datos de la persona desde el cursor
                String name = cursor.getString(cursor.getColumnIndex("nombre")); // Reemplaza "nombre" con el nombre real de la columna en tu base de datos
                String email = cursor.getString(cursor.getColumnIndex("email")); // Reemplaza "email" con el nombre real de la columna en tu base de datos
                String pass = cursor.getString(cursor.getColumnIndex("contraseña")); // Reemplaza "contraseña" con el nombre real de la columna en tu base de datos

                // Mostrar los datos en los TextViews
                view_nombre.setText("Nombre: " + name);
                view_email.setText("Email: " + email);
                view_pass.setText("Contraseña: " + pass);
            } else {
                // No se encontró la persona con el ID especificado
                view_nombre.setText("Persona no encontrada");
                view_email.setText("");
                view_pass.setText("");
            }

            cursor.close();
            db.close();
        }
    }
