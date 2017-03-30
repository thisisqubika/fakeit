package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.RockBandData;
import com.mooveit.library.Fakeit;

public class RockBandViewModel extends BaseViewModel {

    private RockBandData mData;

    public RockBandViewModel(RockBandData data) {
        this.mData = data;
        setBusinessData();
    }

    public RockBandData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.rockBandName.set(Fakeit.rockBand().name());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}