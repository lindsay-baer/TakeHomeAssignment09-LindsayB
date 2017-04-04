package com.example.android.takehomeassignment09_lindsayb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity {

    private EditText lieType;
    private EditText outRageousness;
    private CheckBox withRussia;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference lieRef = database.getReference("Lielist");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lieType = (EditText) findViewById(R.id.lie_type);
        outRageousness = (EditText) findViewById(R.id.outrageous);
        withRussia = (CheckBox) findViewById(R.id.russia);
    }

    public void anotherLie(View view) {
        String lie = lieType.getText().toString();
        int scale = Integer.parseInt(outRageousness.getText().toString());
        boolean russian = withRussia.isChecked();

        Lie l = new Lie(lie, scale, russian);
        lieRef.push().setValue(l);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}