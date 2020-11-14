package com.example.nhom6_6;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnDangKi, btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
    private void setEvent() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, DangKi.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, DonhangThukho.class);
                startActivity(intent);
            }
        });


    }

    private void setControl() {
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKi = findViewById(R.id.btnDangKi);


    }
}