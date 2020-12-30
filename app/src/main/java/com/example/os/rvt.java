package com.example.os;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.content.Context;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class rvt extends RecyclerView.Adapter<rvt.ViewHolder> {

    private List<task> taskList;
    private Context con ;

    public rvt(Context context, List<task> taskList) {
        this.con  = context;
        this.taskList = taskList;

    }
    @NonNull
    @Override
    public rvt.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.taskes, viewGroup, false);


        return new ViewHolder(view, con );
    }

    @Override
    public void onBindViewHolder(@NonNull final rvt.ViewHolder viewHolder, int position) {
        viewHolder.setData(taskList.get(position));
        final task taskEntity = taskList.get(position);
        if (taskEntity.getIsChecked()) {
            viewHolder.checkBox.setChecked(true);
            viewHolder.checkBox.setPaintFlags(viewHolder.checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                taskEntity.setIsChecked(isChecked);
                viewHolder.checkBox.setSelected(isChecked);
                if (isChecked) {
                    viewHolder.checkBox.setText(taskEntity.getTaskName());
                    viewHolder.checkBox.setPaintFlags(viewHolder.checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }


                else {
                    viewHolder.checkBox.setText(taskEntity.getTaskName());
                    viewHolder.checkBox.setPaintFlags(viewHolder.checkBox.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox checkBox;

        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);

            con  = ctx;

            checkBox = itemView.findViewById(R.id.checkBox);

        }

        public void setData(task task) {
            checkBox.setText(task.getTaskName());
            checkBox.setSelected(task.getIsChecked());
        }

    }

}
