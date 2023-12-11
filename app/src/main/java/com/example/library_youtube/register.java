package com.example.library_youtube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    private Button register;
    private EditText email, password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.etemail);
        password = findViewById(R.id.etpassword);
        register = findViewById(R.id.btnregister);

        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = email.getText().toString();
                String pw = password.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pw)) {
                    Toast.makeText(register.this, "Input username and password", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(username, pw);
                }
            }
        });
    }

    private void registerUser(String username, String pw) {
        auth.createUserWithEmailAndPassword(username, pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(register.this, "Register Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(register.this, login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(register.this, "Register Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}