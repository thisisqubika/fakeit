package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class HackerData extends BaseObservable {

    public final ObservableField<String> hackerAbbreviation = new ObservableField<>();
    public final ObservableField<String> hackerAdjective = new ObservableField<>();
    public final ObservableField<String> hackerNoun = new ObservableField<>();
    public final ObservableField<String> hackerVerb = new ObservableField<>();
    public final ObservableField<String> hackerIngVerb = new ObservableField<>();
}
