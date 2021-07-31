package com.example.userofkdschool.autentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.userofkdschool.R;
import com.example.userofkdschool.UserHomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {

    private TextView openReg,openForgetPassword;
    private EditText emailLog,passLog;
    private Button logBtn;
    private FirebaseAuth auth;
    private String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance();
        openReg= findViewById(R.id.openRegister);
        emailLog= findViewById(R.id.logEmail);
        passLog= findViewById(R.id.logPass);
        logBtn= findViewById(R.id.login);
        openForgetPassword= findViewById(R.id.openForgetPassword);

        openForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgetPasswordActivity.class));

            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

        openReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

    }

    private void validateData() {
        email= emailLog.getText().toString();
        password= passLog.getText().toString();
        
        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please provide all field", Toast.LENGTH_SHORT).show();
        }else {
            loginUser();
        }
    }

    private void loginUser() {
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            openUserHome();
                        }else {
                            Toast.makeText(LoginActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openUserHome() {
        startActivity(new Intent(LoginActivity.this, UserHomeActivity.class));
        finish();
    }

    private void openRegister() {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        finish();
    }
}