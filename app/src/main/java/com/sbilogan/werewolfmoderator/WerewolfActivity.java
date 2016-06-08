package com.sbilogan.werewolfmoderator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sbilogan.werewolfmoderator.fragments.PlayerFragment;
import com.sbilogan.werewolfmoderator.fragments.PlayerListFragment;

public class WerewolfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_werewolf);

        FragmentManager fm = getSupportFragmentManager();
        Fragment playerListFragment = fm.findFragmentById(R.id.fragment_container);

        if (playerListFragment == null) {

            playerListFragment = new PlayerListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, playerListFragment)
                    .commit();
        }
    }
}
