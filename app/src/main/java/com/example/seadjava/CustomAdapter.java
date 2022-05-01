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
import java.util.zip.Inflater;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<DateModel> dataSet;
    Context context;


    public CustomAdapter(Context context, ArrayList<DateModel> data){
        this.dataSet = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DateModel dateModel = dataSet.get(position);

        holder.textView.setText(dateModel.text);
        //TODO
    }

    @Override
    public int getItemCount() {
        if(dataSet == null)
            return 0;
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       final CustomAdapter customAdapter;
       final TextView textView;
       final RecyclerView recyclerView;

        ViewHolder(@NonNull View itemView , CustomAdapter pvAdapter) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            recyclerView = itemView.findViewById(R.id.listView);

            this.customAdapter = pvAdapter;
        }
    }

}
