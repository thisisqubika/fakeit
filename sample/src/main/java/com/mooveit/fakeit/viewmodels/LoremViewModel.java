package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.LoremData;
import com.mooveit.library.Fakeit;

public class LoremViewModel extends BaseViewModel {

    private LoremData mData;

    public LoremViewModel(LoremData data) {
        this.mData = data;
        setBusinessData();
    }

    public LoremData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.words.set(Fakeit.lorem().words());
        mData.supplemental.set(Fakeit.lorem().supplemental());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}