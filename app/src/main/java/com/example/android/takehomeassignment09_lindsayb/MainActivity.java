package com.example.android.takehomeassignment09_lindsayb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView lieList;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference lieRef = database.getReference("Lielist");
    private ArrayList<Lie> lieArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lieList = (TextView) findViewById(R.id.lie_list);

        lieRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String l) {
                lieArrayList.add(dataSnapshot.getValue(Lie.class));
                displayLies();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String l) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Lie.class) + " has changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Lie.class) + " is removed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String l) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        lieList = (TextView) findViewById(R.id.lie_list);
    }

    public void addLie(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void displayLies() {
        String text = "";
        for (Lie l : lieArrayList)
            text += l;
        lieList.setText(text);
    }
}