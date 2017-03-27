package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.RickAndMortyData;
import com.mooveit.library.Fakeit;

public class RickAndMortyViewModel extends BaseViewModel {

    private RickAndMortyData mData;

    public RickAndMortyViewModel(RickAndMortyData data) {
        this.mData = data;
        setBusinessData();
    }

    public RickAndMortyData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.rickAndMortyCharacter.set(Fakeit.rickAndMorty().character());
        mData.rickAndMortyLocation.set(Fakeit.rickAndMorty().location());
        mData.rickAndMortyQuote.set(Fakeit.rickAndMorty().quote());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}