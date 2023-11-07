package com.example.spotspain;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.spotspain.Database.DatabaseAux;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void changeToRegister(View view) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    public void changeToInicio(View view) {
        Intent intent = new Intent(Login.this, Inicio.class);
        startActivity(intent);
    }
    void iniciarsesion() {
        TextView nameView = findViewById(R.id.userlog);
        SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM users", null);

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);

                TextView data = new TextView(this);
                Button b = new Button(this);
                b.setText("hola");
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Toast.makeText(v.getContext(), name, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login.this, Inicio.class);
                        intent.putExtra("message_key", name);
                        startActivity(intent);

                    }
                });
            }while(cursor.moveToNext() || cursor.equals(nameView));
        }
        db.close();
    }
}