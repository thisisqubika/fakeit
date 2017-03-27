package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class LoremData extends BaseObservable {

    public final ObservableField<String> words = new ObservableField<>();
    public final ObservableField<String> supplemental = new ObservableField<>();
}