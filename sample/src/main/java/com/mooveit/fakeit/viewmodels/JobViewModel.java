package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.JobData;
import com.mooveit.library.Fakeit;

public class JobViewModel extends BaseViewModel {

    private JobData mData;

    public JobViewModel(JobData data) {
        this.mData = data;
        setBusinessData();
    }

    public JobData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.jobPosition.set(Fakeit.job().position());
        mData.jobSeniority.set(Fakeit.job().seniority());
        mData.jobTitle.set(Fakeit.job().title());
        mData.jobField.set(Fakeit.job().field());
        mData.jobKeySkill.set(Fakeit.job().keySkill());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}