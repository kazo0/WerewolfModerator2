package com.sbilogan.werewolfmoderator.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sbilogan.werewolfmoderator.R;
import com.sbilogan.werewolfmoderator.model.GameSession;
import com.sbilogan.werewolfmoderator.model.Player;
import com.sbilogan.werewolfmoderator.model.roles.Villager;

import java.util.List;

/**
 * Created by Steve on 6/5/2016.
 */
public class PlayerListFragment extends Fragment {

    private PlayerAdapter mPlayerAdapter;
    private RecyclerView mPlayerRecyclerView;
    private FloatingActionButton mAddPlayerFab;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_list, container, false);

        mPlayerRecyclerView = (RecyclerView)view.findViewById(R.id.player_recycler_view);
        mPlayerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAddPlayerFab = (FloatingActionButton)view.findViewById(R.id.fab_add_player);
        mAddPlayerFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPlayer();
            }
        });

        updateUI();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_player_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_item_reset:
                resetGame();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        List<Player> players = GameSession.get().getPlayers();

        if (mPlayerAdapter == null) {
            mPlayerAdapter = new PlayerAdapter(players);
            mPlayerRecyclerView.setAdapter(mPlayerAdapter);
        } else {
            mPlayerAdapter.setPlayers(players);
            mPlayerAdapter.notifyDataSetChanged();
        }

        updateSubtitle();

    }

    private void createPlayer() {
        GameSession.get().addPlayer(new Player("Steve", new Villager()));
        updateUI();
        //TODO Open edit player dialog
    }

    private void resetGame() {
        GameSession.get().resetGame(true);
        updateUI();
    }
    private void updateSubtitle() {
        int deathCount = GameSession.get().getDeathCount();
        int aliveCount = GameSession.get().getPlayers().size() - deathCount;

        String subtitle = getString(R.string.player_list_subtitle, aliveCount, deathCount);

        AppCompatActivity activity = (AppCompatActivity)getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private class PlayerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mPlayerLogo;
        private ImageView mPlayerLove;
        private ImageView mPlayerTotem;
        private TextView mPlayerName;
        private TextView mPlayerRole;

        private Player mPlayer;

        public PlayerHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mPlayerLogo = (ImageView)itemView.findViewById(R.id.list_item_player_logo);
            mPlayerLove = (ImageView)itemView.findViewById(R.id.list_item_player_love);
            mPlayerTotem = (ImageView)itemView.findViewById(R.id.list_item_player_totem);
            mPlayerName = (TextView)itemView.findViewById(R.id.list_item_player_name);
            mPlayerRole = (TextView)itemView.findViewById(R.id.list_item_player_role);

        }

        public void bindPlayer(Player player) {
            mPlayer = player;

            mPlayerLogo.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.villager, null));

            if (mPlayer.getLovePartner() != null) {
                mPlayerLove.setVisibility(View.VISIBLE);
                mPlayerLove.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_love, null));
            } else {
                mPlayerLove.setVisibility(View.INVISIBLE);
            }

            if (mPlayer.getTotemFor() != null) {
                mPlayerTotem.setVisibility(View.VISIBLE);
                mPlayerTotem.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_totem, null));
            } else {
                mPlayerTotem.setVisibility(View.INVISIBLE);
            }

            mPlayerName.setText(mPlayer.getName());
            mPlayerRole.setText(mPlayer.getRole().getTitle());
        }


        @Override
        public void onClick(View v) {
            //TODO Navigate to View player fragment
        }
    }

    private class PlayerAdapter extends RecyclerView.Adapter<PlayerHolder> {
        private List<Player> mPlayers;

        public PlayerAdapter(List<Player> players) {
            mPlayers = players;
        }

        @Override
        public PlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_item_player, parent, false);
            return new PlayerHolder(view);
        }

        @Override
        public void onBindViewHolder(PlayerHolder holder, int position) {
            Player player = mPlayers.get(position);

            holder.bindPlayer(player);
        }

        @Override
        public int getItemCount() { return mPlayers.size(); }

        public void setPlayers(List<Player> players) {
            mPlayers = players;
        }
    }
}
