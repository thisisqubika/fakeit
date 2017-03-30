package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class CatData extends BaseObservable {

    public final ObservableField<String> catName = new ObservableField<>();
    public final ObservableField<String> catBreed = new ObservableField<>();
    public final ObservableField<String> catRegistry = new ObservableField<>();
}