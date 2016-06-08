package com.sbilogan.werewolfmoderator.model.roles;

/**
 * Created by Steve on 6/5/2016.
 */
public class BigBadWolf extends Role {
    private boolean mHasExtraKill;

    public BigBadWolf() {
        mIsEvil = true;
    }

    public boolean hasExtraKill() {
        return mHasExtraKill;
    }

    public void setHasExtraKill(boolean hasExtraKill) {
        mHasExtraKill = hasExtraKill;
    }
}
