package com.dev.yazidi.champpool.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.dev.yazidi.champpool.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent;
                switch (item.getItemId())
                {
                    case R.id.nav_scores:
                        startActivity(new Intent(MainActivity.this,ScoresActivity.class));
                        break;
                    case R.id.nav_about:
                        Toast.makeText(MainActivity.this, "Under development", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        List<String> lanes = Arrays.asList(getResources().getStringArray(R.array.lanes));
        GridView gridViewHeader = (GridView) findViewById(R.id.poolListHeader);
        gridViewHeader.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, lanes));


    }
}
