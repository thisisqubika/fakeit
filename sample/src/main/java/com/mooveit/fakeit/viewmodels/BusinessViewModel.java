package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.BusinessData;
import com.mooveit.library.Fakeit;

public class BusinessViewModel extends BaseViewModel {

    private BusinessData mData;

    public BusinessViewModel(BusinessData data) {
        this.mData = data;
        setBusinessData();
    }

    public BusinessData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.businessName.set(Fakeit.business().name());
        mData.businessType.set(Fakeit.business().type());
        mData.businessSubType.set(Fakeit.business().subType());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}