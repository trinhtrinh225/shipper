package com.example.nhom6_6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nhom6_6.Model.ThongtinDH;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;




public class DonhangShipper extends AppCompatActivity {
    Button btnDX;
    ListView listView;
    Firebase root;
    FirebaseAuth mAuth;
    ArrayList<ThongtinDH> arrayListdh = new ArrayList<>();
    DatabaseReference databaseReference;

    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donhang_shipper);
        Intent intent = getIntent();
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseUser = mAuth.getCurrentUser();

        Anhxa();
        Event();


        Firebase.setAndroidContext(this);
        root = new Firebase("https://ecommerceuser-844f8.firebaseio.com");

        try {
            final ArrayList<ThongtinDH> myArrayList = new ArrayList<>();
            final ArrayAdapter<ThongtinDH> myArrayAdapter = new ArrayAdapter<ThongtinDH>(this,
                    android.R.layout.simple_list_item_1,
                    myArrayList);
            listView.setAdapter(myArrayAdapter);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

            ref.child("CartList").child("UserView").child("Products").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ThongtinDH thongtinDH = snapshot.getValue(ThongtinDH.class);
                    arrayListdh.add(thongtinDH);
                    myArrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "error" + e, Toast.LENGTH_SHORT).show();
        }


    }
    private void Event() {
        btnDX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Toast.makeText(DonhangShipper.this,"bạn đã đăng xuất", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DonhangShipper.this, DangNhap.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        btnDX = (Button) findViewById(R.id.dangxuat);
        listView = (ListView)findViewById(R.id.lstdanhsachdonhangshipper);

    }

}