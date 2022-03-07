package com.example.mypepper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aldebaran.qi.sdk.design.activity.RobotActivity;

public class MainActivity extends RobotActivity {

    private static final String TAG = MainActivity.class.getName();

    public Button groupe_button;
    public Button individual_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        groupe_button = (Button) findViewById(R.id.btn_groupe);
        individual_button = (Button) findViewById(R.id.btn_individual);

        groupe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groupeIntent = new Intent(MainActivity.this, GroupeEntry.class);
                startActivity(groupeIntent);
            }
        });

        individual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent individualIntent = new Intent(MainActivity.this,Individual.class);
                startActivity(individualIntent);
            }
        });

    }

}

