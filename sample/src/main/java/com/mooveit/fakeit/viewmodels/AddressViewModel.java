package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.AddressData;
import com.mooveit.library.Fakeit;

public class AddressViewModel extends BaseViewModel {

    private AddressData mData;

    public AddressViewModel(AddressData data) {
        this.mData = data;
        setAddressData();
    }

    public AddressData getData() {
        return mData;
    }

    private void setAddressData() {
        mData.city.set(Fakeit.address().city());
        mData.streetAddress.set(Fakeit.address().streetAddress());
        mData.buildingNumber.set(Fakeit.address().buildingNumber());
        mData.zipCode.set(Fakeit.address().zipCode());
        mData.state.set(Fakeit.address().state());
        mData.stateAbbreviation.set(Fakeit.address().stateAbbreviation());
    }

    @Override
    public void refresh() {
        setAddressData();
    }
}