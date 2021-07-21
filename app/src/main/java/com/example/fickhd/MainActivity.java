package com.example.fickhd;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fickhd.view.AboutFragment;
import com.example.fickhd.view.FavoriteFragment;
import com.example.fickhd.view.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        Toast.makeText(getApplicationContext(), "đây là 1", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_favorite:
                        fragment = new FavoriteFragment();
                        Toast.makeText(getApplicationContext(), "đây là 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about:
                        fragment = new AboutFragment();
                        Toast.makeText(getApplicationContext(), "đây là 3", Toast.LENGTH_SHORT).show();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout_container, fragment).commit();
                return true;
            }
        });


    }


}