package com.example.zakupy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView shoppingRecyclerView;
    private ShoppingAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList<String> shoppingList = new LinkedList<>();

        shoppingList.addLast("mleko");
        shoppingList.addLast("bułki");
        shoppingList.addLast("chleb");
        shoppingList.addLast("jabłka");
        shoppingList.addLast("banany");
        shoppingList.addLast("pomidory");
        shoppingList.addLast("ogórki");
        shoppingList.addLast("ser");
        shoppingList.addLast("joghurt");
        shoppingList.addLast("szynka");
        shoppingList.addLast("jajka");
        shoppingList.addLast("kakao");


        shoppingRecyclerView = findViewById(R.id.recyclerview);
        myAdapter = new ShoppingAdapter(this, shoppingList);
        shoppingRecyclerView.setAdapter(myAdapter);
        shoppingRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}