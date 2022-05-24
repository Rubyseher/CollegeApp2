package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class
LoginActivity3 extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
        btn = findViewById(R.id.button123);
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity3.this,student_page.class);
            startActivity(intent);

        });
    }
}