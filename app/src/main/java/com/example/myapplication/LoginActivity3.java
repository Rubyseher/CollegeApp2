package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.authentication.RegisterActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.example.myapplication.R;
import com.google.android.gms.tasks.Task;

public class
LoginActivity3 extends AppCompatActivity {
    Button btn;

    private EditText  mEmail, mPass;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root =db.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);

        mEmail = findViewById(R.id.user_email);
        mPass = findViewById(R.id.user_pass);
        btn = (Button)findViewById(R.id.button123);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LoginActivity3.this,student_page.class);
//                startActivity(intent);
                String email=mEmail.getText().toString();
                String pass=mPass.getText().toString();

                Log.d("email",email);
                root.child(email).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity3.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(LoginActivity3.this, "Read Success", Toast.LENGTH_SHORT).show();
                            for (DataSnapshot ds : task.getResult().getChildren()) {
                                String key = ds.getKey();
                                String value = ds.getValue(String.class);
                                Log.d("TAG", key + ":" + value);
                                if(key == "pass" && value == pass) {
                                    Toast.makeText(LoginActivity3.this, "Login Success", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LoginActivity3.this, "Invalid Username/pass", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity3.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });

            }

        });
    }

}