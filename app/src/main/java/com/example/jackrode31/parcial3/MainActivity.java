package com.example.jackrode31.parcial3;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add, update, delete, search, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.btnadd);
        update = findViewById(R.id.btnupdate);
        delete = findViewById(R.id.btndel);
        search = findViewById(R.id.btnsearch);
        list = findViewById(R.id.btnall);


    }
}
