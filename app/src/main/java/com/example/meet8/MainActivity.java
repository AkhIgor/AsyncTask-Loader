package com.example.meet8;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Служит для "раздутия" фрагментов на активити, и их отображение.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();  //добавляем фрагменты на активити
        fragmentManager.beginTransaction().add(R.id.frameLayout1, new Fragment1()).commit();
        fragmentManager.beginTransaction().add(R.id.frameLayout2, new Fragment2()).commit();
        fragmentManager.beginTransaction().add(R.id.frameLayout3, new Fragment3()).commit();
    }
}
