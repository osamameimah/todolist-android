package com.example.os;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;


public class lists extends AppCompatActivity {


    private Button save;
    private List<it> itemList;
    private Button create ;
    private AlertDialog dialog;
    private AlertDialog.Builder build ;
    private EditText edit ;
    private RecyclerView recyclerView;
    private rv recyclerViewAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList  = new ArrayList<>();

        recyclerViewAdapter = new rv(this, itemList );
        recyclerView.setAdapter(recyclerViewAdapter);


        create = findViewById(R.id.createList);
        create .setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)   {

                build  = new AlertDialog.Builder(lists.this);
                View view = getLayoutInflater().inflate(R.layout.on, null);
                edit  = view.findViewById(R.id.editText_listName);
                save  = view.findViewById(R.id.saveList);
                build .setView(view);
                dialog = build .create();
                dialog.show();
                save .setOnClickListener(new View.OnClickListener()
                {

                    @Override
                    public void onClick(View v) {
                        if (!edit .getText().toString().isEmpty()){

                            it item = new it();
                            item.setNameOfList(edit .getText().toString());
                            itemList.add(0,item);
                            recyclerViewAdapter.notifyItemInserted(0);
                            recyclerView.smoothScrollToPosition(0);
                            recyclerViewAdapter.notifyDataSetChanged();
                            dialog.dismiss();
                        }

                        else {

                            Snackbar.make(v, "Field is Empty!", Snackbar.LENGTH_SHORT).show();
                        }}

                });
            }
        });

    }}
