package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class finish extends AppCompatActivity {

    private TextView textview12;
    private TextView back;
    private EditText space;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        TextView detsTaskName = findViewById(R.id.dets_taskName);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String taskName = bundle.getString("taskName");

            detsTaskName.setText(taskName);
        }


        back= findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }

        });


        space = findViewById(R.id.space);
        textview12 = findViewById(R.id.textview12);

        if (!space.getText().toString().isEmpty()) {
            space.setEnabled(false);

            textview12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    space.setEnabled(true);

                } });
        }




    }}
