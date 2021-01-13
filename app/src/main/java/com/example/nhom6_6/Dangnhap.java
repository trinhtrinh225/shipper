package com.example.nhom6_6;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom6_6.Model.Acount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DangNhap extends AppCompatActivity {
    EditText tendangnhap , matkhau;
    Button dangnhap , dangki;
    DatabaseReference mData;
    RadioButton shipper , thukhoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        tendangnhap = findViewById(R.id.tendangnhap);
        matkhau = findViewById(R.id.matkhau);
        dangnhap = findViewById(R.id.DangNhap);
        dangki = findViewById(R.id.btnDangKi);
        mData = FirebaseDatabase.getInstance().getReference();
        shipper = findViewById(R.id.shipper);
        thukhoa = findViewById(R.id.thukho);

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mData.child("danhsachtaikhoan").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists())
                        {
                            for (DataSnapshot key : snapshot.getChildren())
                            {
                                Acount acount = key.getValue(Acount.class);
                                String tendangnhap1 = acount.getTendangnhap();
                                String matkhau1 = acount.getMatkhau();
                                String positon1 = acount.getPosition();

                                if(tendangnhap.getText().toString().equals(tendangnhap1)&&matkhau.getText().toString().equals(matkhau1)&&positon1.equals("Shipper"))
                                {
                                    Toast.makeText(DangNhap.this, "dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(DangNhap.this,DonhangShipper.class);

                                    startActivity(intent);
                                    finish();
                                }
                                else if(tendangnhap.getText().toString().equals(tendangnhap1)&&matkhau.getText().toString().equals(matkhau1)&&positon1.equals("Thukho")){
                                    Toast.makeText(DangNhap.this, "dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(DangNhap.this,DonhangThukho.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(DangNhap.this,"Dang nhap that bai",Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DangNhap.this, DangKi.class);
                startActivity(intent);
            }
        });
    }
}