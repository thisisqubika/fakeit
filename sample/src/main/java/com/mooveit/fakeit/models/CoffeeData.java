package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class CoffeeData extends BaseObservable {

    public final ObservableField<String> coffeeBlendName = new ObservableField<>();
    public final ObservableField<String> coffeeOrigin = new ObservableField<>();
    public final ObservableField<String> coffeeVariety = new ObservableField<>();
    public final ObservableField<String> coffeeNotes = new ObservableField<>();
}
