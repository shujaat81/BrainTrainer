package com.example.hasan.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button go;
    private Intent goIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goIntent = new Intent(this, GameActivity.class);

        go = (Button) findViewById(R.id.goID);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goIntent);


            }
        });


    }
}
