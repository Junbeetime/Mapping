package com.gachon.mapping;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DirayActivity extends AppCompatActivity {

    Button mapbutton;
    Button addbutton;
    Button title1;
    Button title2;
    Button title3;
    Button title4;
    Button title5;
    Button title6;
    int TITLECOUNT;
    Button imagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_title);

        this.InitializeView();
        MapListener();
        AddListenr();
        ImageListener();
    }

    public void InitializeView()
    {
        mapbutton = (Button) findViewById(R.id.Map);
        addbutton = (Button) findViewById(R.id.Addbar);
        title1 = (Button) findViewById(R.id.Title1);
        title2 = (Button) findViewById(R.id.Title2);
        title3 = (Button) findViewById(R.id.Title3);
        title4 = (Button) findViewById(R.id.Title4);
        title5 = (Button) findViewById(R.id.Title5);
        title6 = (Button) findViewById(R.id.Title6);
        imagebutton = (Button) findViewById(R.id.Image);
    }

    public void MapListener()
    {
        mapbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent mapintent = new Intent(getApplicationContext(), testActivity.class);
                startActivityForResult(mapintent,101); }

        });
    }

    public void ImageListener()
    {
        imagebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent imageintent = new Intent(getApplicationContext(), TitleActivity.class);
                startActivityForResult(imageintent,101); }

        });
    }


    public void AddListenr()
    {
        TITLECOUNT = 0;
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (TITLECOUNT) {
                    case 0: title1.setVisibility(view.VISIBLE);
                        TITLECOUNT += 1;
                        break;
                    case 1: title2.setVisibility(view.VISIBLE);
                        TITLECOUNT += 1;
                        break;
                    case 2: title3.setVisibility(view.VISIBLE);
                        TITLECOUNT += 1;
                        break;
                    case 3: title4.setVisibility(view.VISIBLE);
                        TITLECOUNT += 1;
                        break;
                    case 4: title5.setVisibility(view.VISIBLE);
                        TITLECOUNT += 1;
                        break;
                    case 5: title6.setVisibility(view.VISIBLE);
                        TITLECOUNT += 1;
                        break;
                }
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){
            //제대로 불렀는지 확인하는것
            if(data != null){//제대로 불렀고 데이터가 잘 들어 있는가 확인
                String name = data.getStringExtra("MAP");
                if(name != null){
                    Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                }
            }
        }

    }



}
