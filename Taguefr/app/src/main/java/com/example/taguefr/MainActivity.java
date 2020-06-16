package com.example.taguefr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.taguefr.Fragments.JournauxFragment;
import com.example.taguefr.Fragments.MagazinesFragment;
import com.example.taguefr.Fragments.SportsFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView nvDrawer;
    private Toolbar  toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        nvDrawer = (NavigationView)findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
        Class FragmentClass = JournauxFragment.class;
        Fragment fragment = null;
        try {
            fragment = (Fragment)FragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectDrawerItem(menuItem);
                return true;
            }
        });
    }

    public void selectDrawerItem(MenuItem menuItem){
        Fragment fragment = null;
        Class FragmentClass;
        switch (menuItem.getItemId()){
            case R.id.journauxItem:
                FragmentClass = JournauxFragment.class;
                toolbar.setBackgroundColor(Color.parseColor("#1E9EB1"));
                break;
            case R.id.sportsItem:
                FragmentClass = SportsFragment.class;
                toolbar.setBackgroundColor(Color.parseColor("#8722C5"));
                break;
            case R.id.magazinesItem:
                FragmentClass = MagazinesFragment.class;
                toolbar.setBackgroundColor(Color.parseColor("#A7AFAE"));
                break;
            default:
                FragmentClass = JournauxFragment.class;

        }
        try {
            fragment = (Fragment)FragmentClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        menuItem.setChecked(true);

        setTitle(menuItem.getTitle());

        drawerLayout.closeDrawers();



    }

}
