package com.sbilogan.werewolfmoderator.model.roles;

/**
 * Created by Steve on 6/5/2016.
 */
public class Witch extends Role {
    private boolean mHasLifePotion;
    private boolean mHasPoisonPotion;

    public Witch() {
        this(true, true);
    }

    public Witch(boolean hasLifePotion, boolean hasPoisonPotion) {
        mHasLifePotion = hasLifePotion;
        mHasPoisonPotion = hasPoisonPotion;
    }

    public boolean hasLifePotion() {
        return mHasLifePotion;
    }

    public void setHasLifePotion(boolean hasLifePotion) {
        mHasLifePotion = hasLifePotion;
    }

    public boolean hasPoisonPotion() {
        return mHasPoisonPotion;
    }

    public void setHasPoisonPotion(boolean hasPoisonPotion) {
        mHasPoisonPotion = hasPoisonPotion;
    }
}
