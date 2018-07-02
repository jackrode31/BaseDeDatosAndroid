package com.example.jackrode31.parcial3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.*;

public class holy extends AppCompatActivity {

    EditText autor, isbn, editorial, titulo, año, area;
    String scenario;
    TextView t;
    Button addupdate;
    private Books newBook, oldBook;
    private Books_Handler books_handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holy);
        newBook = new Books();
        oldBook = new Books();

        autor = findViewById(R.id.autor);
        isbn = findViewById(R.id.isbn);
        editorial = findViewById(R.id.editorial);
        año = findViewById(R.id.año);
        titulo = findViewById(R.id.title);
        area = findViewById(R.id.area);
        t= findViewById(R.id.titleholy);
        addupdate = findViewById(R.id.addupdatebtn);


        scenario = getIntent().getExtras().getString("ESCENARIO");


        if (scenario.equals("ADD")){
            t.setText("Añadir Libro");
            addupdate.setText("Añadir");

            addupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newBook.setautor(autor.getText().toString());
                    newBook.settitle(titulo.getText().toString());
                    newBook.setaño(año.getText().toString());
                    newBook.seteditorial(editorial.getText().toString());
                    newBook.setarea(area.getText().toString());
                    //ewBook.setisbn(isbn.getText().toString());
                    books_handler.addBook(newBook);
                    Toast t = Toast.makeText(holy.this, "El libro "+ newBook.gettitle() + "ha sido añadido!", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(holy.this,MainActivity.class);
                    startActivity(i);

                }
            });


        }else{
            if (scenario.equals("UPDATE")){

                t.setText("Actualizar Libro");
                addupdate.setText("Update");


                /*addupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });*/

            }
        }

    }
}
