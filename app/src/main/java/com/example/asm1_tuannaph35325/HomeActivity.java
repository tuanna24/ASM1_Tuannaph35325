package com.example.asm1_tuannaph35325;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        runWhenTurnOnDevice();
    }



    private void runWhenTurnOnDevice() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    count++;
                    if (count>3) {
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        };
        thread.start();
    }
}