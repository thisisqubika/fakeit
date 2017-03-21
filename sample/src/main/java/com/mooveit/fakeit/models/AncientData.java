package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class AncientData extends BaseObservable {

    public final ObservableField<String> god = new ObservableField<>();
    public final ObservableField<String> primordial = new ObservableField<>();
    public final ObservableField<String> titan = new ObservableField<>();
    public final ObservableField<String> hero = new ObservableField<>();
}
