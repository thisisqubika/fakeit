package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class NameData extends BaseObservable {

    public final ObservableField<String> fullName = new ObservableField<>();
    public final ObservableField<String> fullMiddleName = new ObservableField<>();
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> userName = new ObservableField<>();
}
