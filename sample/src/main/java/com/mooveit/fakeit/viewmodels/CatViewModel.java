package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.CatData;
import com.mooveit.library.Fakeit;

public class CatViewModel extends BaseViewModel {

    private CatData mData;

    public CatViewModel(CatData data) {
        this.mData = data;
        setBusinessData();
    }

    public CatData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.catName.set(Fakeit.cat().name());
        mData.catBreed.set(Fakeit.cat().breed());
        mData.catRegistry.set(Fakeit.cat().registry());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}