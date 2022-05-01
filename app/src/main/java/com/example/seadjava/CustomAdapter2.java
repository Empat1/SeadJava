package com.example.seadjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.ViewHolder> {
    private ArrayList<String> date;
    Context context;


    public CustomAdapter2(ArrayList<String> data, Context context){
        this.date = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item2, parent, false);
        return new CustomAdapter2.ViewHolder(view, this);
    }


    @Override
    public int getItemCount() {
        if(date == null)
            return 0;
        return date.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final CustomAdapter customAdapter;
        final TextView textView;

        ViewHolder(@NonNull View itemView , CustomAdapter pvAdapter) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);

            this.customAdapter = pvAdapter;
        }
    }

}
