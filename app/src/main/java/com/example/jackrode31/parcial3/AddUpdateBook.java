package com.example.jackrode31.parcial3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class AddUpdateBook extends AppCompatActivity {

    EditText autor, isbn, editorial, titulo, año, area;
    String scenario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        autor = findViewById(R.id.autor);
        isbn = findViewById(R.id.isbn);
        editorial = findViewById(R.id.editorial);
        año = findViewById(R.id.año);
        titulo = findViewById(R.id.title);
        area = findViewById(R.id.area);


        //scenario = getIntent().getExtras().getString("ESCENARIO");


        /*if (scenario.equals("ADD")){


        }else{
            if (scenario.equals("UPDATE")){

            }
        }*/

    }


}
