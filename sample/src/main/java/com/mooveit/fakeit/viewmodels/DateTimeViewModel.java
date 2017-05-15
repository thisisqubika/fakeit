package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.DateTimeData;
import com.mooveit.library.Fakeit;

public class DateTimeViewModel extends BaseViewModel {

    private DateTimeData mData;

    public DateTimeViewModel(DateTimeData data) {
        this.mData = data;
        setBusinessData();
    }

    public DateTimeData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.dateFormatter.set(Fakeit.dateTime().dateFormatter());
        mData.timeFormatter.set(Fakeit.dateTime().timeFormatter());
        mData.dateTimeFormatter.set(Fakeit.dateTime().dateTimeFormatter());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}