package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.HarryPotterData;
import com.mooveit.library.Fakeit;

public class HarryPotterViewModel extends BaseViewModel {

    private HarryPotterData mData;

    public HarryPotterViewModel(HarryPotterData data) {
        this.mData = data;
        setBusinessData();
    }

    public HarryPotterData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.harryPotterCharacter.set(Fakeit.harryPotter().character());
        mData.harryPotterLocation.set(Fakeit.harryPotter().location());
        mData.harryPotterQuote.set(Fakeit.harryPotter().quote());
        mData.harryPotterBook.set(Fakeit.harryPotter().book());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}