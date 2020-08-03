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
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taguefr.Item;
import com.example.taguefr.ItemAdapter;
import com.example.taguefr.R;
import com.example.taguefr.RetrofitInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class TweetFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.168.43.13:3000";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tweet_fragment, container, false);
        return rootView;
    }

    private void setItem(View rootView){
        ArrayList<Item> itemList = new ArrayList<>();
        initializeRecycleView(rootView, itemList);

    }
    public void initializeRecycleView(View rootView, ArrayList<Item> itemList){

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycleViewTweet);
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
        BottomNavigationView bottomNavigationView = (BottomNavigationView)rootView.findViewById(R.id.bottom_nav_tweet);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                ArrayList<Item> itemList = new ArrayList<>();

                return true;
            }
        });
    }
}
