package com.dev.yazidi.champpool.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.dev.yazidi.champpool.Database.DatabaseAdapter;
import com.dev.yazidi.champpool.Model.Score;
import com.dev.yazidi.champpool.R;

import java.util.Arrays;
import java.util.List;

public class AddActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Spinner spinner;
    RatingBar ratingBar;
    Button button;

    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

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

        final List<String> champions = Arrays.asList(getResources().getStringArray(R.array.champions));
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.champion_name);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, champions));

        spinner = (Spinner) findViewById(R.id.champion_lane);
        spinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.lanes, R.layout.support_simple_spinner_dropdown_item));

        ratingBar = (RatingBar) findViewById(R.id.champion_score);

        button = (Button) findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (champions.contains(autoCompleteTextView.getText().toString())) {
                   String message = databaseAdapter.addScore(new Score(autoCompleteTextView.getText().toString(), spinner.getSelectedItem().toString(), (int) ratingBar.getRating()));
                    Toast.makeText(AddActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddActivity.this, "Champion not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
