package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.os.Handler;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int FragmentIndex = 0;
    Handler handler= new Handler();
    int Num_fragments = 4;
    ArrayList<Category> category = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    RecyclerView.Adapter adapter;



    static final int Delay = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        CategoryRecycler();


        replaceFragment(getNextFragment());



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                replaceFragment(getNextFragment());
                handler.postDelayed(this, Delay);
            }
        }, Delay);


    }

    public Fragment getNextFragment() {
        FragmentIndex = (FragmentIndex + 1) % Num_fragments;
        switch (FragmentIndex) {
            case 0:
                return new View1Frag();
            case 1:
                return new View2Frag();
            case 2:
                return new View3Frag();
            case 3:
                return new View4Frag();
            default:
                return new View1Frag();
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



        fragmentTransaction.setCustomAnimations(
                R.anim.slide_left,
                0,
                0,
                0
        );
        fragmentTransaction.replace(R.id.View1FragContainer, fragment);

        fragmentTransaction.commit();
    }
    public void CategoryRecycler(){
        recyclerView=findViewById(R.id.RecyclerList);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);
        category.add(new Category("Mart", R.drawable.mart));
        category.add(new Category("Beauty", R.drawable.beauty));
        category.add(new Category("Fashion", R.drawable.fashion));
        category.add(new Category("Decor", R.drawable.decor));
        category.add(new Category("Electronics", R.drawable.electronics));
        category.add(new Category("Delivery", R.drawable.delivery));
        category.add(new Category("New", R.drawable.ne));
        category.add(new Category("Prices", R.drawable.prices));
        category.add(new Category("Sale", R.drawable.sale));
        adapter = new CategoryAdapter(this,category);
        recyclerView.setAdapter(adapter);
    }


}
