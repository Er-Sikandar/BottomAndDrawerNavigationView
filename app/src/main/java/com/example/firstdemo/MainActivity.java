package com.example.firstdemo;

import static com.example.firstdemo.R.drawable.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firstdemo.fragments.CourseFragment;
import com.example.firstdemo.fragments.HomeFragment;
import com.example.firstdemo.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout dd_drawer;
    ImageView drawer_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         drawer_img=findViewById(R.id.img_drawer);
        drawer_img.setBackgroundResource(ic_menu);
        //bottom navigatio
        BottomNavigationView bottomNav = findViewById(R.id.botttom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(this);
        getFragments(new HomeFragment());
//drawer navigation........
        dd_drawer=findViewById(R.id.dd_drawer);
        NavigationView navigationView=findViewById(R.id.navigation);
       drawer_img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dd_drawer.openDrawer(GravityCompat.START);
               drawer_img.setBackgroundResource(ic_left_arrow);
               if (dd_drawer.isDrawerOpen(GravityCompat.START)){
                   dd_drawer.closeDrawer(GravityCompat.START);
                   drawer_img.setBackgroundResource(ic_menu);
               }
           }
       });
navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem itemView) {
        switch (itemView.getItemId()) {
            case R.id.first:
                startActivity(new Intent(MainActivity.this,FirstActivity.class));
                break;
            case R.id.second:
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                break;
        }
        return true;
    }
});



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getFragments(new HomeFragment());
                break;
            case R.id.course:
                getFragments(new CourseFragment());
                break;
            case R.id.profile:
                getFragments(new ProfileFragment());
                break;
        }
        return true;
    }
    public void getFragments(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}