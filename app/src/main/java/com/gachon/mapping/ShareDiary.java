package com.gachon.mapping;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import org.json.JSONArray;

import java.util.HashMap;

public class ShareDiary extends AppCompatActivity  {

    private EditText diary_address;
    private ImageButton btn_back;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabase = database.getReference();
    private FirebaseAuth firebaseAuth;
    private TextView diarycontent;
    private TextView diaryaddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_share_diary);


        ImageButton main;
        diarycontent = (TextView) findViewById(R.id.diary_share_content);
        diaryaddress = (TextView) findViewById(R.id.diary_share_address);
        btn_back = findViewById(R.id.btn_back);


        /////////////////////////////////////////////////////////////////

        readcontent();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /////////////////////////////////////////////////////////////////

        firebaseAuth = FirebaseAuth.getInstance();


        diary_address = findViewById(R.id.diary_address);
        main = findViewById(R.id.diary_marking);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("address",diary_address.getText().toString());
                startActivityForResult(intent,101);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 101){
            if (data != null){
                String address = data.getStringExtra("address");
                if(address != null){
                    diary_address.setText(address);
                    Toast.makeText(ShareDiary.this,address,Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //////////////////////////////////////////////////////////////////////
    // Data Base send //
    private void writecontent(String uid, String address, String content, String title) {
        User user = new User(uid, address, content,title);

        mDatabase.child("다이어리").child(uid).child(title).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        // 성공적으로 저장했습니다.
                        Toast.makeText(ShareDiary.this, "저장 완료!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //실패..
                        Toast.makeText(ShareDiary.this, "실패...", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void readcontent(){
        String uid = FirebaseAuth.getInstance().getUid();
        String title = getIntent().getStringExtra("title");
        mDatabase.child("다이어리").child(uid).child(title).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue(User.class) != null ){
                    User post = snapshot.getValue(User.class);
                    System.out.println(post.getAddress().toString()+"테스트");
                    diaryaddress.setText(post.getAddress().toString());
                    diarycontent.setText(post.getContent().toString());
                }else{
                    Toast.makeText(ShareDiary.this,"데이터없음..",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FireBaseData", "loadpost: onCancelled",error.toException());
            }
        });
    }


}