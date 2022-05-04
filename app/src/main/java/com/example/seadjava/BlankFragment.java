package com.example.seadjava;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BlankFragment extends Fragment implements QueryText {
    RecyclerView listView;
    ArrayList list;
    CustomAdapter adapter;
    ArrayList<DateModel> dats;

    public static BlankFragment newInstance() {

        Bundle args = new Bundle();

        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_blank, container, false);

        listView = root.findViewById(R.id.listView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
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

        dats= new ArrayList<DateModel>();
        dats.add(new DateModel("Ap" , list));
        dats.add(new DateModel("Apll" , arrayList2));
        dats.add(new DateModel("Api" , list));
        dats.add(new DateModel("B" , list));

//
//        Context context = this;
        adapter = new CustomAdapter(getContext(), dats);
        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onQueryText(String newText) {
        adapter = new CustomAdapter(getContext(), CustomAdapter.filter(dats, newText));
        listView.setAdapter(adapter);
    }
}

interface QueryText{
    public void onQueryText(String newText);
}