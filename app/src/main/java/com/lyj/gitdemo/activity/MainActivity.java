package com.lyj.gitdemo.activity;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.lyj.gitdemo.R;
import com.lyj.gitdemo.fragment.HotspotwareFragment;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    HotspotwareFragment hotspotwareFragment;
    FragmentManager fragmentManager;
    FragmentTransaction ft;
    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView= (NavigationView) findViewById(R.id.navigationView);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        container= (FrameLayout) findViewById(R.id.container);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navigationView.setNavigationItemSelectedListener(listener);
        hotspotwareFragment =new HotspotwareFragment();
        replacefragment(hotspotwareFragment);
    }
    private void replacefragment(Fragment fragment){
        fragmentManager=getSupportFragmentManager();
        ft=fragmentManager.beginTransaction();
        hotspotwareFragment =new HotspotwareFragment();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }
    private NavigationView.OnNavigationItemSelectedListener listener=new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.github_hot_repo:
                    Toast.makeText(MainActivity.this, "哟西", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    };
}
