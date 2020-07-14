package com.nextgenlabs.myapplication.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.nextgenlabs.myapplication.Adapters.HomeActivityRAdapter;
import com.nextgenlabs.myapplication.R;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.home_activity_parent_recyclerView);
        recyclerView.setAdapter(new HomeActivityRAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}