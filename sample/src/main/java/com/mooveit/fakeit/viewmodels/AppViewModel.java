package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.AppData;
import com.mooveit.library.Fakeit;

public class AppViewModel extends BaseViewModel {

    private AppData mData;

    public AppViewModel(AppData data) {
        this.mData = data;
        setBusinessData();
    }

    public AppData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.appName.set(Fakeit.app().name());
        mData.appVersion.set(Fakeit.app().version());
        mData.appAuthor.set(Fakeit.app().author());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}