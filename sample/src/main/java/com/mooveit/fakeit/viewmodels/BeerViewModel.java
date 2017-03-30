package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.BeerData;
import com.mooveit.library.Fakeit;

public class BeerViewModel extends BaseViewModel {

    private BeerData mData;

    public BeerViewModel(BeerData data) {
        this.mData = data;
        setBusinessData();
    }

    public BeerData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.beerName.set(Fakeit.beer().name());
        mData.beerStyle.set(Fakeit.beer().style());
        mData.beerHop.set(Fakeit.beer().hop());
        mData.beerYeast.set(Fakeit.beer().yeast());
        mData.beerMalts.set(Fakeit.beer().malts());
        mData.beerIbu.set(Fakeit.beer().ibu());
        mData.beerAlcohol.set(Fakeit.beer().alcohol());
        mData.beerBlg.set(Fakeit.beer().blg());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}