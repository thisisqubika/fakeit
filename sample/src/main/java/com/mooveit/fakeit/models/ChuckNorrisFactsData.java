package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class ChuckNorrisFactsData extends BaseObservable {

    public final ObservableField<String> chuckNorrisFact = new ObservableField<>();
}