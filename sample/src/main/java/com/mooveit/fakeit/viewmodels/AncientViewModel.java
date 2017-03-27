package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.AncientData;
import com.mooveit.library.Fakeit;

public class AncientViewModel extends BaseViewModel {

    private AncientData mData;

    public AncientViewModel(AncientData data) {
        this.mData = data;
        setAncientData();
    }

    public AncientData getData() {
        return mData;
    }

    public void setAncientData() {
        mData.god.set(Fakeit.ancient().god());
        mData.primordial.set(Fakeit.ancient().primordial());
        mData.titan.set(Fakeit.ancient().titan());
        mData.hero.set(Fakeit.ancient().hero());
    }

    @Override
    public void refresh() {
        setAncientData();
    }
}