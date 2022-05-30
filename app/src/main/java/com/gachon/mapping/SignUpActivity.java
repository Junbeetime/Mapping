package com.gachon.mapping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText sign_email_text;
    private EditText sign_pwd_text;
    private EditText sign_name_text;
    private EditText sign_phone_text;
    private Button sign_button;
    private ImageButton btn_back;
    FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        InitalizeView();
        sign_backbuttonliestener();
        firebaseAuth = FirebaseAuth.getInstance();

        sign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = sign_email_text.getText().toString().trim();
                String pwd = sign_pwd_text.getText().toString().trim();
                String age = sign_name_text.getText().toString().trim();
                String phone = sign_phone_text.getText().toString().trim();
                // 공백 부분 제거 --> trim

                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>(){
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Toast.makeText(SignUpActivity.this, "등록 에러", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }
        });

    }

    public void InitalizeView(){
        sign_email_text = (EditText) findViewById(R.id.sign_email_edittext);
        sign_pwd_text = (EditText) findViewById(R.id.sign_password_edittext);
        sign_name_text = (EditText) findViewById(R.id.sign_name_edittext);
        sign_phone_text = (EditText) findViewById(R.id.sign_phone_edittext);
        sign_button = (Button) findViewById(R.id.sign_next_button);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
    }

    public void sign_backbuttonliestener(){
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sign_back_intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(sign_back_intent);
            }
        });
    }

}
