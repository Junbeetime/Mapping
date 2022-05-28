package com.gachon.mapping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Diary extends AppCompatActivity {

    // 변수선언
    Button savebutton;
    EditText subjecttext;
    EditText contenttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        InitalizeView();

    }

    public void InitalizeView(){
        savebutton = (Button) findViewById(R.id.diary_save_button);
        subjecttext = (EditText) findViewById(R.id.diary_subject);
        contenttext = (EditText) findViewById(R.id.diary_content);
    }


}