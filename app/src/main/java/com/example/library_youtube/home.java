package com.example.library_youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class home extends AppCompatActivity {

    ImageView btnhome, btncatalog, btnborrowing, btnmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fragmentManager2 = getSupportFragmentManager();
        fragmentManager2.beginTransaction().
                replace(R.id.fragmentContainerView, frHome.class, null).
                setReorderingAllowed(true).
                addToBackStack("name").commit();

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().
                        replace(R.id.fragmentContainerView, frHome.class, null).
                        setReorderingAllowed(true).
                        addToBackStack("name").commit();
            }
        });
        btncatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().
                        replace(R.id.fragmentContainerView, frCatalog.class, null).
                        setReorderingAllowed(true).
                        addToBackStack("name").commit();
            }
        });

        btnborrowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().
                        replace(R.id.fragmentContainerView, frBorrowing.class, null).
                        setReorderingAllowed(true).
                        addToBackStack("name").commit();
            }
        });

        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().
                        replace(R.id.fragmentContainerView, frMore.class, null).
                        setReorderingAllowed(true).
                        addToBackStack("name").commit();
            }
        });


    }
}