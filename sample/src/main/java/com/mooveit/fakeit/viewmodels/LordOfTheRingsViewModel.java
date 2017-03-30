package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.LordOfTheRingsData;
import com.mooveit.library.Fakeit;

public class LordOfTheRingsViewModel extends BaseViewModel {

    private LordOfTheRingsData mData;

    public LordOfTheRingsViewModel(LordOfTheRingsData data) {
        this.mData = data;
        setBusinessData();
    }

    public LordOfTheRingsData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.lotrCharacter.set(Fakeit.lordOfTheRings().character());
        mData.lotrLocation.set(Fakeit.lordOfTheRings().location());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}