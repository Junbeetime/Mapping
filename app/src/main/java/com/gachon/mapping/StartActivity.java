package com.gachon.mapping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button starting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        this.InitializeView();
        LoginLister();

    }

    public void InitializeView(){

        starting = (Button) findViewById(R.id.text_start_button);
    }

    public void LoginLister(){

        starting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(startintent);
            }
        });
    }




}