package com.example.nhom6_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.nhom6_6.Adapter.ThongtinAdapter;
import com.example.nhom6_6.Model.ThongtinDH;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DonhangThukho extends AppCompatActivity {
    Button btnDX;
    Intent intent;


    Firebase root;
    ArrayList<ThongtinDH> arrayListdh = new ArrayList<>();
    ThongtinAdapter adapter;
    FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference reference;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donhang_thukho);
        intent = getIntent();
        mAuth = FirebaseAuth.getInstance();
        Anhxa();
        Event();
        Firebase.setAndroidContext(this);

        root = new Firebase("https://ecommerceuser-844f8.firebaseio.com");

        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayListdh = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference().child("CartList").child("UserView");
        reference.child("Products").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    ThongtinDH thongtinDH = dataSnapshot.getValue(ThongtinDH.class);
                    arrayListdh.add(thongtinDH);
                }
                adapter = new ThongtinAdapter(DonhangThukho.this,arrayListdh);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void Event() {
        btnDX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Toast.makeText(DonhangThukho.this,"bạn đã đăng xuất", Toast.LENGTH_LONG).show();
                intent = new Intent(DonhangThukho.this, DangNhap.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        btnDX = findViewById(R.id.dangxuat);

    }

}