package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.FriendsData;
import com.mooveit.library.Fakeit;

public class FriendsViewModel extends BaseViewModel {

    private FriendsData mData;

    public FriendsViewModel(FriendsData data) {
        this.mData = data;
        setBusinessData();
    }

    public FriendsData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.friendsCharacter.set(Fakeit.friends().character());
        mData.friendsLocation.set(Fakeit.friends().location());
        mData.friendsQuote.set(Fakeit.friends().quote());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}