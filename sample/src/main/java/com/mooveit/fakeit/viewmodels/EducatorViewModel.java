package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.EducatorData;
import com.mooveit.library.Fakeit;

public class EducatorViewModel extends BaseViewModel {

    private EducatorData mData;

    public EducatorViewModel(EducatorData data) {
        this.mData = data;
        setBusinessData();
    }

    public EducatorData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.name.set(Fakeit.educator().name());
        mData.secondary.set(Fakeit.educator().secondary());
        mData.tertiaryType.set(Fakeit.educator().tertiaryType());
        mData.tertiaryCourseSubject.set(Fakeit.educator().tertiaryCourseSubject());
        mData.tertiaryCourseType.set(Fakeit.educator().tertiaryCourseType());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}