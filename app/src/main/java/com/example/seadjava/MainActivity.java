package com.example.seadjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    RecyclerView listView;
    ArrayList list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        listView.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Mango");
        list.add("Grapes");
        list.add("Lemon");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("WWWW");
        arrayList2.add("ssss");

        ArrayList<DateModel> dats= new ArrayList<DateModel>();
        dats.add(new DateModel("2222" , list));
        dats.add(new DateModel("1111" , arrayList2));
        dats.add(new DateModel("3333" , list));
        dats.add(new DateModel("4444" , list));



        adapter = new CustomAdapter(this, dats);
        listView.setAdapter(adapter);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                if(list.contains(query)){
//                    adapter.getFilter().filter(query);
//                }else{
//                    Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
//                }
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
    }


}