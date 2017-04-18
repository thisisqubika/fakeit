package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.NameData;
import com.mooveit.library.Fakeit;

public class NameViewModel extends BaseViewModel {

    private NameData mData;

    public NameViewModel(NameData data) {
        this.mData = data;
        setNameData();
    }

    public NameData getData() {
        return mData;
    }

    private void setNameData() {
        mData.fullName.set(Fakeit.name().firstName() + " " + Fakeit.name().lastName());
        mData.fullMiddleName.set(Fakeit.name().name());
        mData.firstName.set(Fakeit.name().firstName());
        mData.lastName.set(Fakeit.name().lastName());
        mData.title.set(Fakeit.name().title());
    }

    @Override
    public void refresh() {
        setNameData();
    }
}