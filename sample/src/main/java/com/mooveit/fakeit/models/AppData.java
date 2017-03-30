package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class AppData extends BaseObservable {

    public final ObservableField<String> appName = new ObservableField<>();
    public final ObservableField<String> appVersion = new ObservableField<>();
    public final ObservableField<String> appAuthor = new ObservableField<>();
}
