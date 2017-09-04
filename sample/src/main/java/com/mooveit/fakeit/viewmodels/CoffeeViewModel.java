package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.CoffeeData;
import com.mooveit.library.Fakeit;

public class CoffeeViewModel extends BaseViewModel {

    private CoffeeData mData;

    public CoffeeViewModel(CoffeeData data) {
        this.mData = data;
        setCoffeeData();
    }

    public CoffeeData getData() {
        return mData;
    }

    private void setCoffeeData() {
        mData.coffeeBlendName.set(Fakeit.coffee().blendName());
        mData.coffeeOrigin.set(Fakeit.coffee().origin());
        mData.coffeeVariety.set(Fakeit.coffee().variety());
        mData.coffeeNotes.set(Fakeit.coffee().notes());
    }

    @Override
    public void refresh() {
        setCoffeeData();
    }
}
