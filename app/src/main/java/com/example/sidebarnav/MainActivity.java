package com.example.sidebarnav;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sidebarnav.fragments.CulDrinkFragment;
import com.example.sidebarnav.fragments.CulFoodFragment;
import com.example.sidebarnav.fragments.FavFoodFragment;
import com.example.sidebarnav.fragments.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        replaceFragment(new HomeFragment());
        getSupportActionBar().setTitle("Home");

        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_home) {
                replaceFragment(new HomeFragment());
                getSupportActionBar().setTitle("Home");
            } else if (item.getItemId() == R.id.menu_mkn_khas) {
                replaceFragment(new CulFoodFragment());
                getSupportActionBar().setTitle("Makanan Khas");
            } else if (item.getItemId() == R.id.menu_mnm_khas) {
                replaceFragment(new CulDrinkFragment());
                getSupportActionBar().setTitle("Minuman Khas");
            } else {
                replaceFragment(new FavFoodFragment());
                getSupportActionBar().setTitle("Makanan Favorit");
            }

            drawerLayout.closeDrawers();
            return true;
        });
        }

        @Override
        protected void onPostCreate(Bundle savedInstanceState) {
            super.onPostCreate(savedInstanceState);
            toggle.syncState();
            toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.BackgroundBlue));
        }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }
}