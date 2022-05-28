package com.gachon.mapping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    boolean flag;
    Button loginbutton;
    Button signupbutton;
    Button findbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        flag = true;
        InitalizeView();
        LoginListener();
        SignupListener();
        FindListener();
    }

    public void InitalizeView(){
        loginbutton = (Button) findViewById(R.id.login_login_Button);
        signupbutton = (Button) findViewById(R.id.login_signup_Button);
        findbutton = (Button) findViewById(R.id.login_find_Button);
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
                Intent findintent = new Intent(getApplicationContext(), FindService.class);
                startActivity(findintent);
            }
        });
    }
}