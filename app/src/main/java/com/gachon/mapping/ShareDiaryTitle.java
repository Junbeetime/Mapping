package com.gachon.mapping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShareDiaryTitle extends AppCompatActivity {

    private Activity activity;

    private EditText et_item;

    private Button btn_add, btn_delete;

    private ListView lv_array;

    private ArrayAdapter<String> arrayAdapter;

    private List<String> itemList = new ArrayList<>(Arrays.asList());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_diary);

        try {
            setContentView(R.layout.activity_share_diary);

            init();

            setting();

            addListner();

        }catch (Exception ex) {
            LogService.error(this, ex.getMessage(), ex);
        }


    }
    private void init(){
        activity = this;

        et_item = findViewById(R.id.et_item);

        btn_add = findViewById(R.id.btn_add);

        btn_delete = findViewById(R.id.btn_delete);

        lv_array = findViewById(R.id.lv_array);

        arrayAdapter = new ArrayAdapter<>(this, R.layout.diary_title_item, itemList);
    }

    private void setting(){

        lv_array.setAdapter(arrayAdapter);
        lv_array.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    private void addListner(){
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemList.add(et_item.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int index = lv_array.getCheckedItemPosition();

                if(index < 0){
                    Toast.makeText(activity, "삭제 대상을 선택하세요.", Toast.LENGTH_SHORT).show();;
                }
                else{
                    itemList.remove(index);
                    lv_array.clearChoices();
                    et_item.setText("");
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });

        lv_array.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"일기장",Toast.LENGTH_SHORT).show();
            }
        });
    }




}
