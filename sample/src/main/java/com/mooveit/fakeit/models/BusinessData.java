package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.mooveit.fakeit.BR;

public class BusinessData extends BaseObservable {

    public final ObservableField<String> businessName = new ObservableField<>();
    public final ObservableField<String> businessType = new ObservableField<>();
    public final ObservableField<String> businessSubType = new ObservableField<>();
}
