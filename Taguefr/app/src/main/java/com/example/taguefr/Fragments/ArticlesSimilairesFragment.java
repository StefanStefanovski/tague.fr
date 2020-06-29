package com.example.taguefr.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taguefr.ItemArticles;
import com.example.taguefr.ItemArticlesAdapter;
import com.example.taguefr.R;

import java.util.ArrayList;
import java.util.List;

public class ArticlesSimilairesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.articles_similaires_fragment,container,false);

        ArrayList<ItemArticles> ListArticles = new ArrayList<>();
        ListArticles.add(new ItemArticles("Google.com","Régionales 2021. Emmanuel Macron « ouvre le débat » d’un report après la présidentielle", R.drawable.test2));
        ListArticles.add(new ItemArticles("Wikipedia.org","Donald Trump annonce le retrait de près de 10 000 soldats américains d’Allemagne", R.drawable.test3));
        ListArticles.add(new ItemArticles("Youtube.com","Municipales 2020 : le second tour suspendu à l’appréciation du Conseil constitutionnel", R.drawable.test4));
        ListArticles.add(new ItemArticles("Tague.fr","Coronavirus: Le second tour des municipales reporté en Guyane", R.drawable.coronatague));
        ListArticles.add(new ItemArticles("Exemple.mk","Exemple Articles similaires", R.drawable.macedonia));
        ListArticles.add(new ItemArticles("Time.mk","Coronavirus: Le second tour des municipales reporté en Guyane", R.drawable.coronatague));


        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recycleViewArticlesSimilaires);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ItemArticlesAdapter adapter = new ItemArticlesAdapter(ListArticles);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return rootView;


    }
}
