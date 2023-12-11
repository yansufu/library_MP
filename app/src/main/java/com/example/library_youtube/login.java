package com.example.library_youtube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private Button btnlogin;
    TextView btnregister,btnregisterbawah;
    private EditText email, password;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.etemail);
        password = findViewById(R.id.etpassword);
        btnlogin = findViewById(R.id.btnlogin);
        btnregister = findViewById(R.id.tfregister);
        btnregisterbawah = findViewById(R.id.tfregisterbawah);

        auth = FirebaseAuth.getInstance();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });
        btnregisterbawah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(login.this, "Input username and password", Toast.LENGTH_SHORT).show();
                }else {
                    loginUser(username, pass);
                }
            }
        });
    }

    private void loginUser(String username, String pass) {
        auth.signInWithEmailAndPassword(username, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    task.getException();
                    Intent intent = new Intent(login.this, home.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }else {
                    task.getException();
                    Toast.makeText(login.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}