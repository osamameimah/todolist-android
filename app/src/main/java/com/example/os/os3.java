package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class os3 extends AppCompatActivity {
    TextView TView4;

    EditText mfullname;
    EditText mpassword;

    EditText memail;

    Button mbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os3);


        mpassword = findViewById(R.id.Text2);

        memail  =findViewById(R.id.Text1);

        mbtn  =findViewById(R.id.btn );


        TView4=findViewById(R.id.TView4);
        TView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(os3.this,os2.class);
                startActivity(intent);
            }
        });
        /////////////////////////////////////////////////////////////

        String Text1=memail.getText().toString().trim();
        String Text2=mpassword.getText().toString().trim();



        if(TextUtils.isEmpty(Text2)){
            mpassword.setError("Password is Required .");
            return;

        }


        if(Text2.length()<6){

            mpassword.setError("password Must be >=6 characters");
            return;
        }



        if(TextUtils.isEmpty(Text1)){
            memail.setError("Email is Required .");
            return;

        }


        mbtn = findViewById(R.id.btn );
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(os3.this, lists.class);
                startActivity(intent);
            }
        });



    }
}