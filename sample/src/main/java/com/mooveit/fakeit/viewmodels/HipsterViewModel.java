package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.HipsterData;
import com.mooveit.library.Fakeit;

public class HipsterViewModel extends BaseViewModel {

    private HipsterData mData;

    public HipsterViewModel(HipsterData data) {
        this.mData = data;
        setBusinessData();
    }

    public HipsterData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.hipsterWords.set(Fakeit.hipster().words());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}