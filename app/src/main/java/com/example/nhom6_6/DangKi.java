package com.example.nhom6_6;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DangKi extends AppCompatActivity {
     Button btnDangKi, btnDangXuat;
     EditText edttendangnhap,edtten,edtmatkhau,edtxacnhapmatkhau,edtsdt;
     ProgressBar progressBar;
     RadioButton rddshipper,rddthukhoa;

     int i = 0;
     DatabaseReference reference;
     FirebaseDatabase database;
     FirebaseAuth auth = FirebaseAuth.getInstance();

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        intent = getIntent();
        auth = FirebaseAuth.getInstance();
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

            String btn1 = rddshipper.getText().toString();
            String btn2 = rddthukhoa.getText().toString();

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
            if(matkhau.length() < 8)
            {
                Toast.makeText(getApplicationContext(),"Nhập tối đa 8 kí tự , mời bạn nhập mật khẩu",Toast.LENGTH_SHORT).show();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);

            auth.createUserWithEmailAndPassword(edttendangnhap.getText().toString(),edtmatkhau.getText().toString()).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isComplete())
                    {
                        Toast.makeText(DangKi.this,"Dang ki thanh cong!",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        intent = new Intent(DangKi.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(DangKi.this,"Dang ki khong thanh cong! ",Toast.LENGTH_SHORT).show();

                    }
                }
            });
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
        rddthukhoa = findViewById(R.id.rddthukhoa);

    }
}