package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.CodeData;
import com.mooveit.library.Fakeit;

public class CodeViewModel extends BaseViewModel {

    private CodeData mData;

    public CodeViewModel(CodeData data) {
        this.mData = data;
        setBusinessData();
    }

    public CodeData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.codeAsin.set(Fakeit.code().asin());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}