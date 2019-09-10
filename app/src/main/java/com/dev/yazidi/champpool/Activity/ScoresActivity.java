package com.dev.yazidi.champpool.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dev.yazidi.champpool.Adapter.ScoreAdapter;
import com.dev.yazidi.champpool.Database.DatabaseAdapter;
import com.dev.yazidi.champpool.R;

public class ScoresActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        databaseAdapter = new DatabaseAdapter(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), AddActivity.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.scoresList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ScoreAdapter(databaseAdapter.getAllScores(),this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(new ScoreAdapter(databaseAdapter.getAllScores(),this));
    }
}
