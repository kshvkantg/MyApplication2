package com.nextgenlabs.myapplication.ui.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nextgenlabs.myapplication.R;
import com.nextgenlabs.myapplication.ui.fragment.MeetinViewFragment;
import com.nextgenlabs.myapplication.ui.fragment.ProblemViewFragment;
import com.nextgenlabs.myapplication.ui.fragment.ProjectViewFragment;

public class ProjectActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        bottomNavigationView = findViewById(R.id.activity_project_bottom_navigation_view);

        ProjectViewFragment projectViewFragment = new ProjectViewFragment();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.activity_project_fragment_container,projectViewFragment).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new ProjectViewFragment();
                int id;
                switch (item.getItemId()){
                    case R.id.nav_project_intro:
                        fragment = new ProjectViewFragment();
                        break;
                    case R.id.nav_problems:
                        fragment = new ProblemViewFragment();
                        break;
                    case R.id.nav_meetings:
                        fragment = new MeetinViewFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().add(R.id.activity_project_fragment_container,fragment).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_project_fragment_container,fragment).commit();
                return true;
            }
        });
    }
}