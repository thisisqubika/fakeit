package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.HackerData;
import com.mooveit.library.Fakeit;

public class HackerViewModel extends BaseViewModel {

    private HackerData mData;

    public HackerViewModel(HackerData data) {
        this.mData = data;
        setBusinessData();
    }

    public HackerData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.hackerAbbreviation.set(Fakeit.hacker().abbreviation());
        mData.hackerAdjective.set(Fakeit.hacker().adjective());
        mData.hackerNoun.set(Fakeit.hacker().noun());
        mData.hackerVerb.set(Fakeit.hacker().verb());
        mData.hackerIngVerb.set(Fakeit.hacker().ingverb());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}