package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class MusicData extends BaseObservable {

    public final ObservableField<String> key = new ObservableField<>();
    public final ObservableField<String> chord = new ObservableField<>();
    public final ObservableField<String> instrument = new ObservableField<>();
    public final ObservableField<String> keyTypes = new ObservableField<>();
    public final ObservableField<String> chordTypes = new ObservableField<>();
}