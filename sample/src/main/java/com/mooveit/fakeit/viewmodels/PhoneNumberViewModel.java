package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.PhoneNumberData;
import com.mooveit.library.Fakeit;

public class PhoneNumberViewModel extends BaseViewModel {

    private PhoneNumberData mData;

    public PhoneNumberViewModel(PhoneNumberData data) {
        this.mData = data;
        setBusinessData();
    }

    public PhoneNumberData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.formats.set(Fakeit.phone().formats());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}