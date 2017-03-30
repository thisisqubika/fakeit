package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class ArtistData extends BaseObservable {

    public final ObservableField<String> artistName = new ObservableField<>();
}
