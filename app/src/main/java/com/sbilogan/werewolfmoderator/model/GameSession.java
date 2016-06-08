package com.sbilogan.werewolfmoderator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Steve on 6/5/2016.
 */
public class GameSession {
    private static GameSession sGameSession;
    private List<Player> mPlayers;

    public static GameSession get() {
        if (sGameSession == null) {
            sGameSession = new GameSession();
        }
        return sGameSession;
    }

    private GameSession() {
        mPlayers = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        mPlayers.add(player);
    }

    public void removePlayer(Player player) {
        mPlayers.remove(player);
    }

    public List<Player> getPlayers() { return mPlayers; }

    public Player getPlayer(UUID playerId) {
        for (Player p : mPlayers) {
            if (p.getId() == playerId) {
                return p;
            }
        }

        return null;
    }

    public void resetGame(boolean clearPlayers) {
        if (clearPlayers) {
            mPlayers.clear();
            return;
        }

        for (Player p : mPlayers) {
            p.reset();
        }
    }

    public int getDeathCount() {
        int dead = 0;
        for (Player p : mPlayers) {
            if (p.isDead()) {
                dead += 1;
            }
        }

        return dead;
    }
}
