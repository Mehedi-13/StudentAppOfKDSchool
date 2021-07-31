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
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText regName, regPass,regEmail,regPhone;
    private Button register;
    private String name,password,email,phone;
    private FirebaseAuth auth;
    private DatabaseReference reference,dbRef;
    private TextView openLog;

    @Override
    protected void onStart() {
        super.onStart();

        if (auth.getCurrentUser()!= null){
            openUserHome();
        }
    }

    private void openUserHome() {
        startActivity(new Intent(this, UserHomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth= FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference();

        openLog= findViewById(R.id.openLogin);

        regEmail= findViewById(R.id.regEmail);
        regPass= findViewById(R.id.regPass);
        regName= findViewById(R.id.regName);
        regPhone= findViewById(R.id.regPhone);
        register= findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

        openLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });


    }

    private void openLogin() {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
        finish();
    }

    private void validateData() {
        name= regName.getText().toString();
        email= regEmail.getText().toString();
        password= regPass.getText().toString();
        phone= regPhone.getText().toString();

        if (name.isEmpty()){
            regName.setError("Required");
            regName.requestFocus();
        } else if (email.isEmpty()){
            regEmail.setError("Required");
            regEmail.requestFocus();
        }else if (password.isEmpty()){
            regPass.setError("Required");
            regPass.requestFocus();
        }else if (phone.isEmpty()){
            regPhone.setError("Required");
            regPhone.requestFocus();
        }
        else {
            createUser();
        }

    }

    private void createUser() {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            uploadData();

                        }else {
                            Toast.makeText(RegisterActivity.this, "Erroe: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(RegisterActivity.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void uploadData() {

        dbRef=reference.child("users");
        String key= dbRef.push().getKey() ;

        HashMap<String,String >user= new HashMap<>();
        user.put("key",key);
        user.put("name",name);
        user.put("email",email);
        user.put("phone",phone);
        user.put("password",password);

        dbRef.child(key).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if (task.isSuccessful()){

                            Toast.makeText(RegisterActivity.this, "Registration completed successfully.", Toast.LENGTH_SHORT).show();
                            openUserHome();
                            
                        }else {
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(RegisterActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}