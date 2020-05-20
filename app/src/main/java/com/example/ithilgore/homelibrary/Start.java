package com.example.ithilgore.homelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Start extends AppCompatActivity implements View.OnClickListener {
    private ExpandableListView listView;
    private Button home;
    private Button search;
    private Button add;
    List<String> titles;
    HashMap<String, List<String>> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        listView = findViewById(R.id.list);
        search = findViewById(R.id.button3);
        search.setOnClickListener(this);
        add = findViewById(R.id.button2);
        add.setOnClickListener(this);

        titles = new ArrayList<>();
        items = new HashMap<>();
        titles.add("Naznaczona");
        titles.add("Wybrana");
        titles.add("Osaczona");

        List<String> as = new ArrayList<>();
        as.add("Cristen");
        as.add("Cast");
        as.add("Naznaczona");
        as.add("Dom nocy");
        as.add("1");
        as.add("2005");
        as.add("Helion");
        List<String> bs = new ArrayList<>();
        bs.add("Cristen");
        bs.add("Cast");
        bs.add("Wybrana");
        bs.add("Dom nocy");
        bs.add("2");
        bs.add("2006");
        bs.add("Helion");
        List<String> cs = new ArrayList<>();
        cs.add("Cristen");
        cs.add("Cast");
        cs.add("Osaczona");
        cs.add("Dom nocy");
        cs.add("5");
        cs.add("2009");
        cs.add("Helion");
        items.put(titles.get(0), as);
        items.put(titles.get(1), bs);
        items.put(titles.get(2), cs);

        ExpandableListAdapter adapter = new Adapter(this, titles, items);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button3){
            Intent intent = new Intent(this,Search.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.button2){
            Intent intent = new Intent(this,Add.class);
            startActivity(intent);
        }
    }
}

