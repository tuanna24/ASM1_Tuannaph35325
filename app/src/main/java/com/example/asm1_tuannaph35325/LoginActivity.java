package com.example.asm1_tuannaph35325;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUserlogin = findViewById(R.id.edt_username);
        EditText edtPassLogin = findViewById(R.id.edt_password);

        String userName = getIntent().getStringExtra("user_name");
        String userpass = getIntent().getStringExtra("pass_word");
        edtUserlogin.setText(userName);
        edtPassLogin.setText(userpass);

        Button btnDk = findViewById(R.id.btn_dangky);
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                ;
            }
        });

        Button btnLgin = findViewById(R.id.btn_login);
        btnLgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chkUserName = edtUserlogin.getText().toString();
                String chkPassWord = edtPassLogin.getText().toString();
                if(chkUserName.length() ==0 || chkUserName.trim().equals(" ")){
                    Toast.makeText(getApplicationContext(),"Vui lòng nhận tên của bạn !",Toast.LENGTH_SHORT).show();
                }else if(chkPassWord.length() == 0 || chkPassWord.trim().equals(" ")){
                    Toast.makeText(getApplicationContext(),"Vui lòng nhận password của bạn !",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(LoginActivity.this, SelectActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}