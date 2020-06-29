package com.example.taguefr.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taguefr.Item;
import com.example.taguefr.ItemAdapter;
import com.example.taguefr.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class JournauxFragment extends Fragment {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
/*
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView =inflater.inflate(R.layout.journaux_fragment, container, false);
        //return inflater.inflate(R.layout.journaux_fragment, container, false);
        setItem(rootView);
        bottmNavOnclick(rootView);
        return rootView;

    }

    public void setItem (View rootView){
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.test2, "Régionales 2021. Emmanuel Macron « ouvre le débat » d’un report après la présidentielle", "Google.com", "14/06/2020"));
        itemList.add(new Item(R.drawable.test3, "Donald Trump annonce le retrait de près de 10 000 soldats américains d’Allemagne", "Wikipedia.org", "15/06/2020"));
        itemList.add(new Item(R.drawable.test4, "Municipales 2020 : le second tour suspendu à l’appréciation du Conseil constitutionnel", "Youtube.com", "15/07/2020"));
        itemList.add(new Item(R.drawable.coronatague, "Coronavirus: Le second tour des municipales reporté en Guyane", "Tague.fr", "15/07/2020"));
        itemList.add(new Item(R.drawable.macedonia, "journaux Exemple 3", "Google.com", "15/07/2020"));
        initializeRecycleView(rootView, itemList);
        OnArticleClick();

    }

    public void initializeRecycleView(View rootView, ArrayList<Item> itemList){

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycleViewJournaux);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new ItemAdapter(itemList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void OnArticleClick(){
        adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(getActivity(),"ID: "+adapter.getSource(position)+"", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("http://"+adapter.getSource(position)); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }

            @Override
            public void articlesSimilairesOnClick(int position) {
                Toast.makeText(getActivity(),"Articles similaires Clicked: "+ position+"", Toast.LENGTH_SHORT).show();

                Fragment newFragment = new ArticlesSimilairesFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.flContent, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });
    }

    public void bottmNavOnclick(final View rootView){
        BottomNavigationView bottomNavigationView = (BottomNavigationView)rootView.findViewById(R.id.bottomNavigationBarJournaux);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                ArrayList<Item> itemList = new ArrayList<>();
                switch (menuItem.getItemId()){
                    case R.id.ALaUne:
                       /* //ArrayList<Item> itemList = new ArrayList<>();
                        itemList.add(new Item(R.drawable.test2, "Régionales 2021. Emmanuel Macron « ouvre le débat » d’un report après la présidentielle", "Tague.fr", "14/06/2020"));
                        itemList.add(new Item(R.drawable.test3, "Donald Trump annonce le retrait de près de 10 000 soldats américains d’Allemagne", "Tague.fr2", "15/06/2020"));
                        itemList.add(new Item(R.drawable.test4, "Municipales 2020 : le second tour suspendu à l’appréciation du Conseil constitutionnel", "Tague.fr23", "15/07/2020"));
                        itemList.add(new Item(R.drawable.coronatague, "Coronavirus: Le second tour des municipales reporté en Guyane", "Tague.fr23", "15/07/2020"));
                        itemList.add(new Item(R.drawable.macedonia, "journaux Exemple 3", "Tague.fr23", "15/07/2020"));

                        initializeRecycleView(rootView, itemList);*/
                       setItem(rootView);
                        OnArticleClick();
                        break;
                    case R.id.culture:

                        itemList.add(new Item(R.drawable.culturetest1, "La trilogie de Figaro, de Beaumarchais", "Tague.fr", "14/06/2020"));
                        itemList.add(new Item(R.drawable.test3, "TEST2 CULTURE", "Tague.fr2", "15/06/2020"));
                        initializeRecycleView(rootView, itemList);
                        OnArticleClick();
                        break;
                    case R.id.Politique:
                        itemList.add(new Item(R.drawable.culturetest1, "TEST POLITIQUE", "Tague.fr", "14/06/2020"));
                        itemList.add(new Item(R.drawable.test3, "TEST2 POLITIQUE", "Tague.fr2", "15/06/2020"));
                        initializeRecycleView(rootView, itemList);
                        OnArticleClick();
                        break;
                    case R.id.France:
                        itemList.add(new Item(R.drawable.culturetest1, "TEST FRANCE", "Tague.fr", "14/06/2020"));
                        itemList.add(new Item(R.drawable.test3, "TEST2 FRANCE", "Tague.fr2", "15/06/2020"));
                        initializeRecycleView(rootView, itemList);
                        OnArticleClick();
                        break;

                }

                return true;
            }
        });
    }
}
