package com.gachon.mapping;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Diary extends AppCompatActivity  {

    private ImageButton btn_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        ImageButton main;

        EditText diary_address;
  /////////////////////////////////////////////////////////////////


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
  /////////////////////////////////////////////////////////////////


        diary_address = findViewById(R.id.diary_address);
        main = findViewById(R.id.diary_marking);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("address",diary_address.getText().toString());
                startActivity(intent);
            }
        });

   ////////////////////////////////////////////////////////////////////





    }




}
