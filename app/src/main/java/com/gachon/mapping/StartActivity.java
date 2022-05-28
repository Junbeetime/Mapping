package com.gachon.mapping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button startbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        this.InitalizeView();
        StartListener();

    }

    public void InitalizeView(){
        startbutton =(Button) findViewById(R.id.text_start_button);
    }

    public void StartListener(){

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startintent =new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(startintent);
            }
        });
    }

}