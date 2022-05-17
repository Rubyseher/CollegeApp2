package com.example.myapplication.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class RegisterActivity extends AppCompatActivity {

    private EditText regName, regEmail, regPass;
    private Button register;
    private String name,email,pass;
    private FirebaseAuth auth;
    private DatabaseReference reference ;
    private DatabaseReference dbRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth= FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference();

        regName = findViewById(R.id.regName);
        regEmail = findViewById(R.id.regEmail);
        regPass = findViewById(R.id.regPass);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(auth.getCurrentUser()!=null){
            openMain();
        }
    }
    private void openMain(){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    private void validateData(){
        name= regName.getText().toString();
        email= regName.getText().toString();
        pass= regName.getText().toString();

        if(name.isEmpty()){
            regName.setError("Required");
            regName.requestFocus();
        }
        else if(email.isEmpty()){
            regEmail.setError("Required");
            regEmail.requestFocus();
        }
        else if(pass.isEmpty()){
            regPass.setError("Required");
            regPass.requestFocus();
        }
        else{
            createUser();
        }
    }

    private void createUser(){
        auth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            uploadData();
                        }else{
                            Toast.makeText(RegisterActivity.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e){
                Toast.makeText(RegisterActivity.this, "Error"+e.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadData(){
        dbRef =reference.child("users");
        String key = dbRef.push().getKey();

        HashMap<String,String> user = new HashMap<>();
        user.put("key",key);

        user.put("name",name);
        user.put("email",email);

        dbRef.child(key).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User created", Toast.LENGTH_SHORT).show();
                            openMain();
                        }else{
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e){
                Toast.makeText(RegisterActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}