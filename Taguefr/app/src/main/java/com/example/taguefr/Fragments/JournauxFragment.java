package com.example.taguefr.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taguefr.Item;
import com.example.taguefr.ItemAdapter;
import com.example.taguefr.R;

import java.util.ArrayList;

public class JournauxFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
/*
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.journaux_fragment, container, false);
        //return inflater.inflate(R.layout.journaux_fragment, container, false);
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.journaux, "journaux Exemple 1", "Tague.fr", "14/06/2020"));
        itemList.add(new Item(R.drawable.sports, "journaux Exemple 2", "Tague.fr2", "15/06/2020"));
        itemList.add(new Item(R.drawable.magazines, "journaux Exemple 3", "Tague.fr23", "15/07/2020"));
        itemList.add(new Item(R.drawable.macedonia, "journaux Exemple 3", "Tague.fr23", "15/07/2020"));

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycleViewJournaux);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new ItemAdapter(itemList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;

    }
/*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.journaux, "journaux Exemple 1", "Tague.fr", "14/06/2020"));
        itemList.add(new Item(R.drawable.sports, "journaux Exemple 2", "Tague.fr2", "15/06/2020"));
        itemList.add(new Item(R.drawable.magazines, "journaux Exemple 3", "Tague.fr23", "15/07/2020"));

        recyclerView = (RecyclerView)view.findViewById(R.id.recycleViewJournaux);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new ItemAdapter(itemList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

    }*/
}
