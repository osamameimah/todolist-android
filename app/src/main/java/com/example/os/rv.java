package com.example.os;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;


public class rv extends RecyclerView.Adapter<rv.ViewHolder> {

    private List<it> itemList;

    private Context con ;

    public rv(Context context, List<it> itemList) {
        this.con  = context;
        this.itemList = itemList;

    }

    @NonNull
    @Override
    public rv.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);

        return new ViewHolder(view, con );
    }


    @Override
    public void onBindViewHolder(@NonNull rv.ViewHolder holder, int position) {
        it item = itemList.get(position);
        holder.nameOfList.setText(item.getNameOfList());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameOfList;

        public ViewHolder(@NonNull View itemView, Context c) {
            super(itemView);

            con  = c;

            nameOfList = itemView.findViewById(R.id.nameOfList);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    it item = itemList.get(position);
                    Intent intent = new Intent(con , task.class);
                    intent.putExtra("listName", item.getNameOfList());


                    con .startActivity(intent);
                }

            });

        }
    }
}

