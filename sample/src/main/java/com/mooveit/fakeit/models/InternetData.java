package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class InternetData extends BaseObservable {

    public final ObservableField<String> internetFreeEmail = new ObservableField<>();
    public final ObservableField<String> internetDomainSuffix = new ObservableField<>();
}
