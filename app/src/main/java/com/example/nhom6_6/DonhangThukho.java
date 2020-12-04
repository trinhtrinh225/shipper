package com.example.nhom6_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class DonhangThukho extends AppCompatActivity {
    Button btnDX;
    Intent intent;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donhang_thukho);
        intent = getIntent();
        mAuth = FirebaseAuth.getInstance();
        Anhxa();
        Event();
    }
    private void Event() {
        btnDX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Toast.makeText(DonhangThukho.this,"bạn đã đăng xuất", Toast.LENGTH_LONG).show();
                intent = new Intent(DonhangThukho.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        btnDX = findViewById(R.id.dangxuat);
    }

}