package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class CardData extends BaseObservable {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> brand = new ObservableField<>();
    public final ObservableField<String> number = new ObservableField<>();
    public final ObservableField<String> type = new ObservableField<>();
    public final ObservableField<String> expirationDate = new ObservableField<>();
}
