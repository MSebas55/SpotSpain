package com.example.spotspain;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.spotspain.Database.DatabaseAux;
        import com.example.spotspain.Database.User;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.firestore.FirebaseFirestore;

        import java.util.HashMap;
        import java.util.Map;

public class Login extends AppCompatActivity {
    public TextView forgotPassword;
    private EditText editTextUser, editTextPassword;
    private Button buttonLogin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotPassword = (TextView) findViewById(R.id.forgotPasswordText);
        forgotPassword.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setTitle("¿Olvidaste tu contraseña?")
                    .setMessage("Puedes recuperarla a través de tu correo electrónico.")
                    //.setView(taskEditText)

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.search_go, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        });
        mAuth = FirebaseAuth.getInstance();
        editTextUser = findViewById(R.id.inputuser);
        editTextPassword = findViewById(R.id.inputpassword);
        buttonLogin = findViewById(R.id.loginButton);

        /*buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextUser.getText().toString();
                String password = editTextPassword.getText().toString();
                signIn(email, password);
            }
        });*/
    }

    public void changeToRegister(View view) {
        Intent intent = new Intent(Login.this, SearchActivity.class);
        startActivity(intent);
    }
    public void checkUser(View v) {
        EditText nameEditText = findViewById(R.id.inputuser);
        EditText passEditText = findViewById(R.id.inputpassword);

        String nameString = nameEditText.getText().toString();
        String passString = passEditText.getText().toString();

        DatabaseAux aux = new DatabaseAux(Login.this);
        SQLiteDatabase db = aux.getReadableDatabase();

        if (db != null) {
            String[] columns = {"name"};
            String selection = "name = ? AND pass = ?";
            String[] selectionArgs = {nameString, passString};

            Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    Toast.makeText(this, "Iniciando sesión", Toast.LENGTH_LONG).show();
                    nameEditText.setText("");
                    passEditText.setText("");
                    Intent nIntent = new Intent(Login.this,Inicio.class);
                    startActivity(nIntent);
                } else {
                    Toast.makeText(this, "usuario o la contraseña estan mal introducidos.", Toast.LENGTH_LONG).show();
                }
                cursor.close();
            }
            db.close();
        }
    }
    /*private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Inicio de sesión exitoso
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                            // Puedes redirigir a otra actividad o realizar otras acciones aquí
                        } else {
                            // Si falla el inicio de sesión, muestra un mensaje al usuario
                            Toast.makeText(Login.this, "Error en el inicio de sesión", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
      }*/
}