package com.gachon.mapping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    boolean flag;
    private Button loginbutton;
    private Button signupbutton;
    private Button findbutton;
    private EditText email_text;
    private EditText pwd_text;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        flag = true;
        InitalizeView();
        SignupListener();
        FindListener();

        firebaseAuth = firebaseAuth.getInstance();

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = email_text.getText().toString().trim();
                String pwd = pwd_text.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(id,pwd)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(LoginActivity.this,"로그인 실패",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }

    public void InitalizeView(){
        loginbutton = (Button) findViewById(R.id.login_login_Button);
        signupbutton = (Button) findViewById(R.id.login_signup_Button);
        findbutton = (Button) findViewById(R.id.login_find_Button);
        email_text = (EditText) findViewById(R.id.login_textid);
        pwd_text = (EditText) findViewById(R.id.login_text_password);
    }

    public void LoginListener(){

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag == true){
                Intent startintent =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startintent);}
                else{
                    Toast.makeText(getApplicationContext(),"로그인 정보가 옳바르지 않습니다",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void SignupListener(){

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupintent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(signupintent);
            }
        });
    }

    public void FindListener(){

        findbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findintent = new Intent(getApplicationContext(), FindActivity.class);
                startActivity(findintent);
            }
        });
    }
}