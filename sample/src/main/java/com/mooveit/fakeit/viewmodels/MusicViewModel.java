package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.MusicData;
import com.mooveit.library.Fakeit;

public class MusicViewModel extends BaseViewModel {

    private MusicData mData;

    public MusicViewModel(MusicData data) {
        this.mData = data;
        setBusinessData();
    }

    public MusicData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.key.set(Fakeit.music().key());
        mData.chord.set(Fakeit.music().chord());
        mData.instrument.set(Fakeit.music().instrument());
        mData.keyTypes.set(Fakeit.music().keyTypes());
        mData.chordTypes.set(Fakeit.music().chordTypes());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}