package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.authentication.RegisterActivity;

public class student_page extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);
        btn = (Button)findViewById(R.id.button123);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this,upload_notice_admin.class);
                startActivity(intent);

            }

        });
        btn = (Button)findViewById(R.id.btn11);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this,upload_announcement_admin.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn12);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this,student_detials_admin.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn13);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this,faculty_details_admin.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn14);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn15);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this,faculty_details_student.class);
                startActivity(intent);

            }
        });

        btn = (Button)findViewById(R.id.btn16);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this,student_details_student.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn17);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this,help_student.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn18);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(student_page.this, LoginActivity3.class);
                startActivity(intent);
            }
        });





    }
}