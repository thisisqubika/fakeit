package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class HarryPotterData extends BaseObservable {

    public final ObservableField<String> harryPotterCharacter = new ObservableField<>();
    public final ObservableField<String> harryPotterLocation = new ObservableField<>();
    public final ObservableField<String> harryPotterQuote = new ObservableField<>();
    public final ObservableField<String> harryPotterBook = new ObservableField<>();
}
