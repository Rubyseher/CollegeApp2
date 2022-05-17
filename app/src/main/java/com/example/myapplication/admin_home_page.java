package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.authentication.RegisterActivity;

public class admin_home_page extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home_page.this,upload_notice_admin.class);
                startActivity(intent);

            }

        });
        btn = (Button)findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home_page.this,upload_announcement_admin.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home_page.this,student_detials_admin.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home_page.this,faculty_details_admin.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home_page.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home_page.this,upload_ebook_faculty.class);
                startActivity(intent);

            }
        });

        btn = (Button)findViewById(R.id.btn7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home_page.this,help_admin.class);
                startActivity(intent);
            }
        });
        btn =  (Button)findViewById(R.id.btn8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home_page.this, LoginActivity.class);
                startActivity(intent);
            }
        });





    }
}