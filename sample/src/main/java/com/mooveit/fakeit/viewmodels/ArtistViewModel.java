package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.ArtistData;
import com.mooveit.library.Fakeit;

public class ArtistViewModel extends BaseViewModel {

    private ArtistData mData;

    public ArtistViewModel(ArtistData data) {
        this.mData = data;
        setBusinessData();
    }

    public ArtistData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.artistName.set(Fakeit.artist().name());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}