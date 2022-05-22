package com.example.myapplication.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class RegisterActivity extends AppCompatActivity {

    private EditText mName, mEmail, mPass;
    private Button button;

    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root =db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mName = findViewById(R.id.regName);
        mEmail = findViewById(R.id.regEmail);
        mPass = findViewById(R.id.regPass);
        button = findViewById(R.id.register);

        button.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                String name=mName.getText().toString();
                String email=mEmail.getText().toString();
                String pass=mPass.getText().toString();

                HashMap<String,String> userMap=new HashMap<>();

                userMap.put("name",name);
                userMap.put("email",email);
                userMap.put("pass",pass);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        Toast.makeText(RegisterActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
