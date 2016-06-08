package com.sbilogan.werewolfmoderator.model.roles;

/**
 * Created by Steve on 6/5/2016.
 */
public class AccursedWolfFather extends Role {
    private boolean mCanInfect;

    public AccursedWolfFather() {
        mIsEvil = true;
        mCanInfect = true;
    }

    public boolean canInfect() {
        return mCanInfect;
    }

    public void setCanInfect(boolean canInfect) {
        mCanInfect = canInfect;
    }
}
