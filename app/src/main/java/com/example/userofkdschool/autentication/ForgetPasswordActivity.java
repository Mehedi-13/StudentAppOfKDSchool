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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class ForgetPasswordActivity extends AppCompatActivity {

    private TextView openlogIN;
    private Button foegetBtn;
    private EditText emailTxt;
    private String email;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        openlogIN=findViewById(R.id.openlogIN);
        auth=FirebaseAuth.getInstance();
        emailTxt=findViewById(R.id.foegetEmail);
        foegetBtn=findViewById(R.id.forgetBtn);

        foegetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });


        openlogIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPasswordActivity.this,LoginActivity.class));
                finish();
            }
        });

    }

    private void validateData() {
        email= emailTxt.getText().toString();
        if (email.isEmpty()){
            emailTxt.setError("Required");
            emailTxt.requestFocus();
        }else {
            forgetPass();
        }
    }

    private void forgetPass() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgetPasswordActivity.this, "Check your Email", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(ForgetPasswordActivity.this,LoginActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(ForgetPasswordActivity.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}