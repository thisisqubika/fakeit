package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.HeyArnoldData;
import com.mooveit.library.Fakeit;

public class HeyArnoldViewModel extends BaseViewModel {

    private HeyArnoldData mData;

    public HeyArnoldViewModel(HeyArnoldData data) {
        this.mData = data;
        setBusinessData();
    }

    public HeyArnoldData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.heyArnoldCharacter.set(Fakeit.heyArnold().character());
        mData.heyArnoldLocation.set(Fakeit.heyArnold().location());
        mData.heyArnoldQuote.set(Fakeit.heyArnold().quote());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}