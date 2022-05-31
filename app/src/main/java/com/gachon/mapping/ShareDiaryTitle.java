package com.gachon.mapping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShareDiaryTitle extends AppCompatActivity implements View.OnClickListener
{
    private Activity activity;

    private EditText et_item;


    private Button btn_add, btn_load;
    private RecyclerView rv_click_apply;
    private DatabaseReference mDatabase;
    private ClickApplyAdapter clickApplyAdapter;
    private List<String> itemNameList;
    private ImageButton btn_back;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();


        try
        {
            setContentView(R.layout.activity_share_diary_title);
            init();
            setting();
            load_btn_listener();
            addListener();

        }
        catch(Exception ex)
        {
            LogService.error(this, ex.getMessage(), ex);
        }



    }


    private void init()
    {


        activity = this;

        et_item = findViewById(R.id.et_item);

        btn_load = findViewById(R.id.btn_load);

        btn_back = findViewById(R.id.btn_back);

        rv_click_apply = findViewById(R.id.rv_click_apply);

        itemNameList = new ArrayList<>();

        clickApplyAdapter = new ClickApplyAdapter(activity, itemNameList, this, this);
    }

    private void setting()
    {
        rv_click_apply.setAdapter(clickApplyAdapter);

        // 리니어 레이아웃 매니저로 수직으로 배치 설정
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_click_apply.setLayoutManager(linearLayoutManager);
    }

    private void addListener()
    {

        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        if(view.getId() == R.id.btn_look_item)
        {
            int position = (int) view.getTag();
            String title = itemNameList.get(position).toString();
            System.out.println(title);
            //context = this;
            Intent intent =new Intent(getApplicationContext(), Diary.class);
            intent.putExtra("title",title);
            startActivity(intent);
        }

        else if (view.getId() == R.id.btn_back){
            finish();
        }



    }

    public void load_btn_listener(){

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid = firebaseAuth.getUid();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("공유다이어리").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if(!task.isSuccessful()){
                            Log.e("firebase", "Error getting data", task.getException());
                        }else{
                            //System.out.println(task.getResult().getValue() + "테스트11");
                            int start;
                            int end;
                            int trash2;
                            String Value = task.getResult().getValue().toString();
                            do {

                                int titleNum = Value.indexOf("title=");

                                if (titleNum != -1) {
                                    Value = Value.substring(titleNum);
                                    start = Value.indexOf("=") + 1;
                                    end = Value.indexOf(",");
                                    Value = Value.substring(start);
                                    String trash;
                                    trash = Value.substring(0, end);
                                    System.out.println("\n" + trash + "테스트");
                                    trash2 = trash.indexOf(",");
                                    trash = trash.substring(0,trash2);
                                    itemNameList.add(trash);
                                    clickApplyAdapter.notifyDataSetChanged();
                                }
                            }while(Value.indexOf("title=") != -1);




                        }
                    }
                });


            }
        });

    }








}

