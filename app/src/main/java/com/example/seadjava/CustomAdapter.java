package com.example.seadjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        if(!dateModel.text.equals(""))
            holder.textView.setText(dateModel.text);
        else
            holder.textView.setVisibility(View.GONE);
        //TODO
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(new CustomAdapter2(dateModel.texts, context));

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search search = (Search) context;
                search.onSearch(dateModel.text);
            }
        });
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
       final LinearLayout card;

        ViewHolder(@NonNull View itemView , CustomAdapter pvAdapter) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            recyclerView = itemView.findViewById(R.id.listView);
            card = itemView.findViewById(R.id.card);

            this.customAdapter = pvAdapter;
        }
    }


    public static ArrayList filter(ArrayList<DateModel> arrayList , String filter){
        ArrayList<DateModel> out = new ArrayList<>();
        int maxLength = 7;
        int listLength=0;

        for(DateModel dateModel : arrayList){
            ArrayList<String> arrayList1 = new ArrayList<>();
            for(String text: dateModel.texts){
                if(strInStr(text , filter) && arrayList1.size() < 4) {
                    arrayList1.add(text);
                    listLength++;
                }
                if(listLength == maxLength)
                    break;
            }

            if(strInStr(dateModel.text, filter)){
                out.add(new DateModel(dateModel.text , arrayList1));
            }else{
                out.add(new DateModel("" , arrayList1));
            }

            if(listLength == maxLength)
                break;
        }

        return out;
    }

    public static boolean strInStr(String s1, String s2){
        return s1.toLowerCase().indexOf(s2.toLowerCase()) == 0;
    }

}
