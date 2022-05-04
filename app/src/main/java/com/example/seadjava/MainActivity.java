package com.example.seadjava;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.Toast;
import android.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Search{

    SearchView searchView;
    RecyclerView listView;
    ArrayList list;
    CustomAdapter adapter;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        frameLayout = findViewById(R.id.fragment);


        BlankFragment blankFragment = BlankFragment.newInstance();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, blankFragment);
        transaction.commit();
//
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)){
//                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
                blankFragment.onQueryText(newText);
                return false;
            }
        });
    }

    @Override
    public void onSearch(String s) {
        searchView.setQuery(s , true);
    }
}

interface Search{
    public void onSearch(String s);
}