package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class RickAndMortyData extends BaseObservable {

    public final ObservableField<String> rickAndMortyCharacter = new ObservableField<>();
    public final ObservableField<String> rickAndMortyLocation = new ObservableField<>();
    public final ObservableField<String> rickAndMortyQuote = new ObservableField<>();
}
