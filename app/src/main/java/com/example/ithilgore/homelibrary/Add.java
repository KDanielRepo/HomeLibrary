package com.example.ithilgore.homelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends AppCompatActivity implements View.OnClickListener {
    private EditText aimie;
    private EditText anazwisko;
    private EditText atytul;
    private EditText aseria;
    private EditText atom;
    private EditText arok;
    private EditText awydanie;

    private Button azdj;
    private Button do1;
    private Button do2;
    private Button home;
    private Button search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        aimie=findViewById(R.id.aimie);
        anazwisko=findViewById(R.id.anazwisko);
        atytul=findViewById(R.id.atytul);
        aseria=findViewById(R.id.aseria);
        atom=findViewById(R.id.atom);
        arok=findViewById(R.id.arokwyd);
        awydanie=findViewById(R.id.awydanie);

        home = findViewById(R.id.button4);
        home.setOnClickListener(this);
        search = findViewById(R.id.button6);
        search.setOnClickListener(this);

        azdj=findViewById(R.id.dozdj);
        do1=findViewById(R.id.do1);
        do2=findViewById(R.id.do2);
        azdj.setOnClickListener(this);
        do1.setOnClickListener(this);
        do2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.dozdj){}
        if (v.getId()==R.id.do1){Intent intent = new Intent(this,Search.class);
        Book book = new Book(
                aimie.getText().toString(),
                anazwisko.getText().toString(),
                atytul.getText().toString(),
                aseria.getText().toString(),
                atom.getText().toString(),
                arok.getText().toString(),
                awydanie.getText().toString()
                );
        intent.putExtra("book",book);
        startActivity(intent);
        }
        if (v.getId()==R.id.do2){}
        if(v.getId()==R.id.button4){
            Intent intent = new Intent(this,Start.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.button6){
            Intent intent = new Intent(this,Search.class);
            startActivity(intent);
        }
    }

}
