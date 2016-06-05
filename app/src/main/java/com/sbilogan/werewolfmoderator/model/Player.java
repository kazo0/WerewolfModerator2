package com.sbilogan.werewolfmoderator.model;

import com.sbilogan.werewolfmoderator.model.roles.Role;

import java.util.List;
import java.util.UUID;

/**
 * Created by Steve on 6/5/2016.
 */
public class Player {

    private UUID mId;
    private String mName;
    private boolean mIsDead;
    private Player mLovePartner;
    private Player mTotemFor;
    private List<Role> mRoles;

    public Player(String name, List<Role> roles) {
        this(name, false, null, null, roles);
    }

    public Player(String name, boolean isDead, Player lovePartner, Player totemFor, List<Role> roles) {
        mId = UUID.randomUUID();

        mName = name;
        mIsDead = isDead;
        mLovePartner = lovePartner;
        mTotemFor = totemFor;
        mRoles = roles;
    }

    public void reset() {
        mIsDead = false;
        mLovePartner = null;
        mTotemFor = null;
        mRoles.clear();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean isDead() {
        return mIsDead;
    }

    public void setDead(boolean dead) {
        mIsDead = dead;
    }

    public Player getLovePartner() {
        return mLovePartner;
    }

    public void setLovePartner(Player lovePartner) {
        mLovePartner = lovePartner;
    }

    public Player getTotemFor() {
        return mTotemFor;
    }

    public void setTotemFor(Player totemFor) {
        mTotemFor = totemFor;
    }

    public List<Role> getRoles() {
        return mRoles;
    }

    public void setRoles(List<Role> roles) {
        mRoles = roles;
    }

    public void kill() {
        mIsDead = true;
        //TODO kill logic
    }
}
