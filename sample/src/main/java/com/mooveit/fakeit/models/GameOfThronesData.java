package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class GameOfThronesData extends BaseObservable {

    public final ObservableField<String> gotCharacter = new ObservableField<>();
    public final ObservableField<String> gothHouse = new ObservableField<>();
    public final ObservableField<String> gotCity = new ObservableField<>();
    public final ObservableField<String> gotQuote = new ObservableField<>();
    public final ObservableField<String> gotDragon = new ObservableField<>();
}
