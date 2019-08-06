package com.dev.yazidi.champpool.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.GridView;

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

        List<String> lanes = Arrays.asList(getResources().getStringArray(R.array.lanes));
        GridView gridViewHeader = (GridView) findViewById(R.id.poolListHeader);
        gridViewHeader.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, lanes));
    }
}
