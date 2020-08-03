package com.example.taguefr.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
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

public class SportsFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.168.43.13:3000";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sports_fragment, container, false);
        bottmNavOnclick(rootView);
        return rootView;
    }

    private void setItem(View rootView){
        ArrayList<Item> itemList = new ArrayList<>();
        initializeRecycleView(rootView, itemList);

    }
    public void initializeRecycleView(View rootView, ArrayList<Item> itemList){

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycleViewSports);
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
        final BottomNavigationView bottomNavigationView = (BottomNavigationView)rootView.findViewById(R.id.bottomSports);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                ArrayList<Item> itemList = new ArrayList<>();
                switch (menuItem.getItemId()){
                    case R.id.ALaUneSports:
                        Toast.makeText(rootView.getContext(), "clicked sports a la une", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.FootballSports:
                        Toast.makeText(rootView.getContext(), "clicked sports a la football", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.BasketballSports:
                        Toast.makeText(rootView.getContext(), "clicked sports a la basket", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.RugbySports:
                        Toast.makeText(rootView.getContext(), "clicked sports a la basket", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.PlusSports:
                        PopupMenu popup = new PopupMenu(rootView.getContext(), bottomNavigationView);
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.plus_sports, popup.getMenu());
                        popup.show();

                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        /*switch (item.getItemId()){
            case R.id.GolfSports:
                Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        }*/
        
        return true;
    }
}
