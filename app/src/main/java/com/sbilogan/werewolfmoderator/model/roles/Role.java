package com.sbilogan.werewolfmoderator.model.roles;

import java.io.File;
import java.util.UUID;

/**
 * Created by Steve on 6/5/2016.
 */
public abstract class Role {
    protected UUID mId;
    protected String mTitle;
    protected String mShortDescription;
    protected String mDescription;
    protected String mImageUrl;
    protected boolean mHasPowers;
    protected boolean mIsEvil;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.mShortDescription = shortDescription;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.mImageUrl = imageUrl;
    }

    public boolean hasPowers() {
        return mHasPowers;
    }

    public void setHasPowers(boolean hasPowers) {
        this.mHasPowers = hasPowers;
    }

    public boolean isEvil() {
        return mIsEvil;
    }

    public void setEvil(boolean evil) {
        mIsEvil = evil;
    }
}
