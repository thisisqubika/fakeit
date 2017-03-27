package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.BankData;
import com.mooveit.library.Fakeit;

public class BankViewModel extends BaseViewModel {

    private BankData mData;

    public BankViewModel(BankData data) {
        this.mData = data;
        setBusinessData();
    }

    public BankData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.bankCountryCode.set(Fakeit.bank().bankCountryCode());
        mData.bankIbanDigits.set(Fakeit.bank().bankCountryCode());
        mData.bankIbanLetterCode.set(Fakeit.bank().ibanLetterCode());
        mData.bankName.set(Fakeit.bank().name());
        mData.bankSwiftBic.set(Fakeit.bank().swiftBic());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}