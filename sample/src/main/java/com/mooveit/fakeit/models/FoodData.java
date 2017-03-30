package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class FoodData extends BaseObservable {

    public final ObservableField<String> ingredient = new ObservableField<>();
    public final ObservableField<String> spice = new ObservableField<>();
    public final ObservableField<String> measurement = new ObservableField<>();
}
