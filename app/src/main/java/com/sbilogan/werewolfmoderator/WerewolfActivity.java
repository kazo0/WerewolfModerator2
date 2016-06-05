package com.sbilogan.werewolfmoderator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WerewolfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_werewolf);

        FragmentManager fm = getSupportFragmentManager();
        Fragment playerListFragment = fm.findFragmentById(R.id.fragment_container);



        fm.beginTransaction()
                .add(R.id.fragment_container, playerListFragment)
                .commit();
    }
}
