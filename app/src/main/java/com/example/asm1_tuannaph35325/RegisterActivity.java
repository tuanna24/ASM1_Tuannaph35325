package com.example.asm1_tuannaph35325;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button btnlogin = findViewById(R.id.btn_login);
        Button btnreturn = findViewById(R.id.btn_returnhome);
        EditText edtUserName = findViewById(R.id.edt_username);
        EditText edtPassWord = findViewById(R.id.edt_password);
        EditText edtPassWordAgain = findViewById(R.id.edt_passwordagain);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check null
                String checkUser = edtUserName.getText().toString();

                String checkPassOne = edtPassWord.getText().toString();

                String checkPassTwo = edtPassWordAgain.getText().toString();
                if (checkUser.length()==0 || checkUser.trim().equals(" ")){
                    Toast.makeText(getApplicationContext(),"Can nhap username! ",Toast.LENGTH_SHORT).show();

                }else if(checkPassOne.length()==0 || checkPassOne.trim().equals(" ")){
                    Toast.makeText(getApplicationContext(),"Can nhap password! ",Toast.LENGTH_SHORT).show();
                }else if (checkPassTwo.length()==0 ) {
                    Toast.makeText(getApplicationContext(),"Can nhap lai  password! ",Toast.LENGTH_SHORT).show();

                } else if (!checkPassTwo.equalsIgnoreCase(checkPassOne)) {
                    Toast.makeText(getApplicationContext(),"password nhap lai khong dung!",Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("user_name",checkUser);
                    intent.putExtra("pass_word",checkPassOne);
                    startActivity(intent);
                }
            }
        });

        Button btnBackLogin = findViewById(R.id.btn_returnhome);
        btnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}