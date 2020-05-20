package com.example.ithilgore.homelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Have extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have);

        Book book = (Book) getIntent().getSerializableExtra("book");
        System.out.println(book.getImie()+book.getTytul());
    }

}
