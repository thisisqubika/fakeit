package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.InternetData;
import com.mooveit.library.Fakeit;

public class InternetViewModel extends BaseViewModel {

    private InternetData mData;

    public InternetViewModel(InternetData data) {
        this.mData = data;
        setBusinessData();
    }

    public InternetData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.internetFreeEmail.set(Fakeit.internet().freeEmail());
        mData.internetDomainSuffix.set(Fakeit.internet().domainSuffix());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}