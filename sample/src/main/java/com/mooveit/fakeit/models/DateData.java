package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class DateData extends BaseObservable {

    public final ObservableField<String> date = new ObservableField<>();
    public final ObservableField<String> dateBetweenRanges = new ObservableField<>();
    public final ObservableField<String> dateInTheFuture = new ObservableField<>();
    public final ObservableField<String> dateInThePast = new ObservableField<>();
}