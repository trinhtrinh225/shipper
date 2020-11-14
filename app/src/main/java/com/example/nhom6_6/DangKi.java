package com.example.nhom6_6;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DangKi extends AppCompatActivity {
    Button btnDangKi, btnDangXuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        setControl();
        setEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    private void setEvent() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DangKi.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DangKi.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void setControl() {
        btnDangXuat = findViewById(R.id.btnDangXuat);
        btnDangKi = findViewById(R.id.btnDangKi);


    }
}