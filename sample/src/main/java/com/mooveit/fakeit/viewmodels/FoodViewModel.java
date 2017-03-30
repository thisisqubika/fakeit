package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.FoodData;
import com.mooveit.library.Fakeit;

public class FoodViewModel extends BaseViewModel {

    private FoodData mData;

    public FoodViewModel(FoodData data) {
        this.mData = data;
        setBusinessData();
    }

    public FoodData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.ingredient.set(Fakeit.food().ingredient());
        mData.spice.set(Fakeit.food().spice());
        mData.measurement.set(Fakeit.food().measurement());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}