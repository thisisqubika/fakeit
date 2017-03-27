package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.CompanyData;
import com.mooveit.library.Fakeit;

public class CompanyViewModel extends BaseViewModel {

    private CompanyData mData;

    public CompanyViewModel(CompanyData data) {
        this.mData = data;
        setBusinessData();
    }

    public CompanyData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.companySuffix.set(Fakeit.company().suffix());
        mData.companyBuzzwords.set(Fakeit.company().buzzwords());
        mData.companyBs.set(Fakeit.company().bs());
        mData.companyName.set(Fakeit.company().name());
        mData.companyIndustry.set(Fakeit.company().industry());
        mData.companyProfession.set(Fakeit.company().profession());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}