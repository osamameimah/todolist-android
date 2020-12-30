package com.example.os;



import java.util.List;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;



public class tasks extends AppCompatActivity {


    private RecyclerView recyclerViewtask;
    private rvt recyclerViewAdaptertask;
    private List<task> taskList;
    private Button btn;
    private AlertDialog alertDialog;
    private EditText name;
    private AlertDialog.Builder build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);


        TextView detsListName = findViewById(R.id.dets_listName);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String listName = bundle.getString("listName");

            detsListName.setText(listName + " List");

        }

        recyclerViewtask = findViewById(R.id.recyclerViewTask);
        recyclerViewtask.setHasFixedSize(true);
        recyclerViewtask.setLayoutManager(new LinearLayoutManager(this));

        taskList = new ArrayList<>();

        recyclerViewAdaptertask = new rvt(this, taskList );
        recyclerViewtask.setAdapter(recyclerViewAdaptertask);

        Button btn_createTask = findViewById(R.id.btn_createTask);
        btn_createTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopDialog();
            }
        });

        TextView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void createPopDialog() {
        build  = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.on, null);
        name = view.findViewById(R.id.editText_listName);
        btn = view.findViewById(R.id.saveList);

        TextView title = view.findViewById(R.id.addList);
        title.setText("Enter Task Name : ");
        name.setHint("Task Name");

        build.setView(view);
        alertDialog = build.create();
        alertDialog.show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty()) {
                    saveItem(v);
                } else {
                    Snackbar.make(v, "Field is Empty!", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveItem(View v) {

        String newItemNOT = name.getText().toString().trim();

        task task = new task(newItemNOT, false);
        taskList.add(0, task);
        recyclerViewAdaptertask.notifyItemInserted(0);
        recyclerViewtask.smoothScrollToPosition(0);

        alertDialog.dismiss();
    }

    public void onCheckboxClicked(View view) {
    }
}