package com.example.nhom6_6;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.nhom6_6.Model.Acount;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DangKi extends AppCompatActivity {
     Button btnDangKi, btnDangXuat;
     EditText edttendangnhap,edtten,edtmatkhau,edtxacnhapmatkhau,edtsdt;
     ProgressBar progressBar;
     RadioButton rddshipper,rddthukho;
     Acount acount;
     int i = 0;
     DatabaseReference mData;
     FirebaseAuth auth = FirebaseAuth.getInstance();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        intent = getIntent();
        auth = FirebaseAuth.getInstance();
        mData = FirebaseDatabase.getInstance().getReference();
        setControl();
        setEvent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    private void setEvent() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                String tendangnhap = edttendangnhap.getText().toString().trim();
                String ten = edtten.getText().toString().trim();
                String matkhau = edtmatkhau.getText().toString().trim();
                String xacnhanmk = edtxacnhapmatkhau.getText().toString().trim();
                String sdt = edtsdt.getText().toString().trim();
                if(TextUtils.isEmpty(tendangnhap)){
                    Toast.makeText(getApplicationContext(),"Mời bạn nhập tên đăng nhập",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ten))
                {
                    Toast.makeText(getApplicationContext(),"Mời bạn nhập tên ",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(matkhau)){
                    Toast.makeText(getApplicationContext(),"Mời bạn nhập mật khẩu",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(xacnhanmk))
                {
                    Toast.makeText(getApplicationContext(),"Mời bạn nhập mật khẩu xác nhận",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(sdt))
                {
                    Toast.makeText(getApplicationContext(),"Mời bạn nhập số điện thoại",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(matkhau.length() < 6)
                {
                    Toast.makeText(getApplicationContext(),"Nhập ít nhất 6 kí tự , mời bạn nhập mật khẩu",Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                String chucvu;
                if(rddshipper.isChecked())
                {
                    chucvu = "Shipper";
                }
                else{
                    chucvu = "Thukho";
                }
                acount = new Acount(edttendangnhap.getText().toString(),edtten.getText().toString(),edtmatkhau.getText().toString(),edtxacnhapmatkhau.getText().toString(),edtsdt.getText().toString(),chucvu.toString());
                if(chucvu.equals("Shipper"))
                {

                        mData.child("danhsachtaikhoan").child(edtten.getText().toString()).setValue(acount);
                    Toast.makeText(DangKi.this, "dang ki thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DangKi.this,DangNhap.class);
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }
                else if(chucvu.equals("Thukho")){
                    mData.child("danhsachtaikhoan").child(edtten.getText().toString()).setValue(acount);
                    Toast.makeText(DangKi.this, "dang ki thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DangKi.this,DangNhap.class);
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }
            }
        });
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    private void setControl() {
        btnDangXuat = findViewById(R.id.btnDangXuat);
        btnDangKi = findViewById(R.id.btnDangKi);
        edttendangnhap = findViewById(R.id.tendangnhap);
        edtten = findViewById(R.id.ten);
        edtmatkhau = findViewById(R.id.matkhau);
        edtxacnhapmatkhau = findViewById(R.id.xacnhanmatkhau);
        edtsdt = findViewById(R.id.sdt);
        progressBar = findViewById(R.id.progressBar);
        rddshipper = findViewById(R.id.rddshipper);
        rddthukho = findViewById(R.id.rddthukhoa);

    }
}