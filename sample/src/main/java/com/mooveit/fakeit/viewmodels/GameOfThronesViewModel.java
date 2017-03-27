package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.GameOfThronesData;
import com.mooveit.library.Fakeit;

public class GameOfThronesViewModel extends BaseViewModel {

    private GameOfThronesData mData;

    public GameOfThronesViewModel(GameOfThronesData data) {
        this.mData = data;
        setBusinessData();
    }

    public GameOfThronesData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.gotCharacter.set(Fakeit.gameOfThrones().character());
        mData.gothHouse.set(Fakeit.gameOfThrones().house());
        mData.gotCity.set(Fakeit.gameOfThrones().city());
        mData.gotQuote.set(Fakeit.gameOfThrones().quote());
        mData.gotDragon.set(Fakeit.gameOfThrones().dragon());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}