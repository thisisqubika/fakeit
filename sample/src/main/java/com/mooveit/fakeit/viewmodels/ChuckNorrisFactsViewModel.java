package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.ChuckNorrisFactsData;
import com.mooveit.library.Fakeit;

public class ChuckNorrisFactsViewModel extends BaseViewModel {

    private ChuckNorrisFactsData mData;

    public ChuckNorrisFactsViewModel(ChuckNorrisFactsData data) {
        this.mData = data;
        setBusinessData();
    }

    public ChuckNorrisFactsData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.chuckNorrisFact.set(Fakeit.chuckNorris().fact());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}