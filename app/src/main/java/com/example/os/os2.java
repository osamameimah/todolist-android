package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class os2 extends AppCompatActivity {

    EditText mfullname;
    EditText mpassword;

    EditText memail;

    Button mbtn;
    TextView mlog;


    TextView Viewl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os2);

        mfullname =findViewById(R.id.Edit1);
        mpassword = findViewById(R.id.Edit2);

        memail  =findViewById(R.id.Edit1);

        mbtn  =findViewById(R.id.btnn);
        mlog  =findViewById(R.id.Viewl);

        //////////////////////////////////////////////////////////////////////
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/////////////////////////////////////////////////////////////////////////////////////////////////////

                Viewl = findViewById(R.id.Viewl);
                Viewl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(os2.this, os3.class);
                        startActivity(intent);
                    }
                });

                /////////////////////////////////////////////////////////////////////////////////////

                mbtn = findViewById(R.id.btnn);
                mbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(os2.this, lists.class);
                        startActivity(intent);
                    }
                });


                ///////////////////////////////////////////////////////////////
                String Edit3=memail.getText().toString().trim();
                String Edit2=mpassword.getText().toString().trim();

                String Edit1=mfullname.getText().toString().trim();


                if(TextUtils.isEmpty(Edit3)){
                    memail.setError("Email is Required .");
                    return;

                }

                if(TextUtils.isEmpty(Edit1)){
                    mfullname.setError("your name is Required .");
                    return;

                }


                if(TextUtils.isEmpty(Edit2)){
                    mpassword.setError("Password is Required .");
                    return;

                }


                if(Edit2.length()<6){

                    mpassword.setError("password Must be >=6 characters");
                    return;
                }




            }
        });
    }
}








