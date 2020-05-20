package com.example.ithilgore.homelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Search extends AppCompatActivity implements View.OnClickListener {
    private EditText simie;
    private EditText snazwisko;
    private EditText stytul;
    private EditText sseria;
    private EditText stom;
    private EditText srok;
    private EditText swydanie;
    private Button sszukaj;
    private ExpandableListView listView;
    private Button home;
    private Button add;
    List<String> titles;
    HashMap<String, List<String>> items;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listView = findViewById(R.id.list);

        home = findViewById(R.id.button);
        home.setOnClickListener(this);
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

        if(getIntent().getSerializableExtra("book")!=null){
            Book book = (Book) getIntent().getSerializableExtra("book");
            List<String> booke = new ArrayList<>();
            booke.add(book.getImie());
            booke.add(book.getNazwisko());
            booke.add(book.getTytul());
            booke.add(book.getSeria());
            booke.add(book.getTom());
            booke.add(book.getRokWydania());
            booke.add(book.getWydawnictwo());
            titles.add(book.getTytul());
            items.put(titles.get(3), booke);
        }
        ExpandableListAdapter adapter = new Adapter(this, titles, items);
        listView.setAdapter(adapter);


        sszukaj = findViewById(R.id.sszukaj);
        sszukaj.setOnClickListener(this);

        stytul = findViewById(R.id.stytul);
        simie=findViewById(R.id.simie);
        snazwisko=findViewById(R.id.snazwisko);
        sseria=findViewById(R.id.sseria);
        stom=findViewById(R.id.stom);
        swydanie=findViewById(R.id.swydanie);
        srok=findViewById(R.id.srokwyd);

    }

    public boolean allNull(){
        return stytul==null || stytul.getText().toString().equals("") || stytul.getText().toString().equals(" ")
                &&
                simie==null || simie.getText().toString().equals("") || simie.getText().toString().equals(" ")
                &&
                snazwisko==null || snazwisko.getText().toString().equals("") || snazwisko.getText().toString().equals(" ")
                &&
                stom==null || stom.getText().toString().equals("") || stom.getText().toString().equals(" ")
                &&
                swydanie==null || swydanie.getText().toString().equals("") || swydanie.getText().toString().equals(" ")
                &&
                sseria==null || sseria.getText().toString().equals("") || sseria.getText().toString().equals(" ")
                &&
                srok==null || srok.getText().toString().equals("") || srok.getText().toString().equals(" ");

    }
    public int notAllNull(){
        int i = 0;
        if(stytul==null || stytul.getText().toString().equals("") || stytul.getText().toString().equals(" ")){
            i++;
        }
        if(simie==null || simie.getText().toString().equals("") || simie.getText().toString().equals(" ")){
            i++;
        }
        if(snazwisko==null || snazwisko.getText().toString().equals("") || snazwisko.getText().toString().equals(" ")){
            i++;
        }
        if(stom==null || stom.getText().toString().equals("") || stom.getText().toString().equals(" ")){
            i++;
        }
        if(swydanie==null || swydanie.getText().toString().equals("") || swydanie.getText().toString().equals(" ")){
            i++;
        }
        if(sseria==null || sseria.getText().toString().equals("") || sseria.getText().toString().equals(" ")){
            i++;
        }
        if(srok==null || srok.getText().toString().equals("") || srok.getText().toString().equals(" ")){
            i++;
        }
        return i;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sszukaj) {
            if(allNull()){
                ExpandableListAdapter adapter = new Adapter(this,titles,items);
                listView.setAdapter(adapter);
            }else{
                List<String> newTitles = new ArrayList<>();
                HashMap<String,List<String>> newItems = new HashMap<>();
                int i = 0;
                for(String st : items.keySet()){
                    if(st.equals(stytul.getText().toString())){
                        newTitles.add(st);
                        newItems.put(newTitles.get(i),items.get(st));
                        i++;
                    }
                }
                ExpandableListAdapter adapter = new Adapter(this,newTitles,newItems);
                listView.setAdapter(adapter);
            }
        }
        if(v.getId()==R.id.button){
            Intent intent = new Intent(this,Start.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.button2){
            Intent intent = new Intent(this,Add.class);
            startActivity(intent);
        }
    }
}






/*listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        titles.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        titles.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        titles.get(groupPosition)
                                + " -> "
                                + items.get(
                                titles.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });*/
