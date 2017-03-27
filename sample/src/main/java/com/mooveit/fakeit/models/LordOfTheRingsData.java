package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class LordOfTheRingsData extends BaseObservable {

    public final ObservableField<String> lotrCharacter = new ObservableField<>();
    public final ObservableField<String> lotrLocation = new ObservableField<>();
}