package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class PokemonData extends BaseObservable {

    public final ObservableField<String> pokemonName = new ObservableField<>();
    public final ObservableField<String> pokemonLocation = new ObservableField<>();
}