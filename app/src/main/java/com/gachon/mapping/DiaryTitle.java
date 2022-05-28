package com.gachon.mapping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiaryTitle extends AppCompatActivity {

    private Activity activity;

    private EditText et_item;

    private Button btn_add, btn_delete;

    private RecyclerView rv_click_apply;

    private ClickApplyAdapter clickApplyAdapter;

    private List<String> itemTitleList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            setContentView(R.layout.activity_diary_title);

            init();

            setting();

            addListner();

        }catch (Exception ex) {
            LogService.error(this, ex.getMessage(), ex);
        }


    }
    @SuppressLint("WrongViewCast")
    private void init(){

        activity = this;

        et_item = findViewById(R.id.et_item);

        btn_add = findViewById(R.id.btn_add);

        btn_delete = findViewById(R.id.btn_delete);

        rv_click_apply = findViewById(R.id.rv_click_apply);



    }

    private void setting(){

        rv_click_apply.setAdapter(clickApplyAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_click_apply.setLayoutManager(linearLayoutManager);
    }

    private void addListner(){

        btn_add.setOnClickListener(this);



    }




}

