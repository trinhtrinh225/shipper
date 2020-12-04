package com.example.nhom6_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nhom6_6.Model.DHShip;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;


public class DonhangShipper extends AppCompatActivity {
    Button btnDX;
    ListView listView;
    Firebase root;
    FirebaseAuth mAuth;
    ArrayList<String> myArrayList;
    DHShip DHShip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donhang_shipper);
        Intent intent = getIntent();
        mAuth = FirebaseAuth.getInstance();

        Anhxa();
        Event();
        Firebase.setAndroidContext(this);
        root = new Firebase("https://shipper-dc26c.firebaseio.com");

        final ArrayList<String> myArrayList = new ArrayList<>();
        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                myArrayList);
        listView.setAdapter(myArrayAdapter);

        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                myArrayList.add(dataSnapshot.getValue().toString());
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void Event() {
        btnDX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Toast.makeText(DonhangShipper.this,"bạn đã đăng xuất", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DonhangShipper.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        btnDX = (Button) findViewById(R.id.dangxuat);
        listView = (ListView) findViewById(R.id.lstdanhsachdonhangshipper);

    }

}