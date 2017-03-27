package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.DemographicData;
import com.mooveit.library.Fakeit;

public class DemographicViewModel extends BaseViewModel {

    private DemographicData mData;

    public DemographicViewModel(DemographicData data) {
        this.mData = data;
        setBusinessData();
    }

    public DemographicData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.race.set(Fakeit.demographic().race());
        mData.educationalAttainment.set(Fakeit.demographic().educationalAttainment());
        mData.demonym.set(Fakeit.demographic().demonym());
        mData.maritalStatus.set(Fakeit.demographic().maritalStatus());
        mData.sex.set(Fakeit.demographic().sex());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}