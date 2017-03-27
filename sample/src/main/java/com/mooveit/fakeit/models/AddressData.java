package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class AddressData extends BaseObservable {

    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<String> streetAddress = new ObservableField<>();
    public final ObservableField<String> buildingNumber = new ObservableField<>();
    public final ObservableField<String> zipCode = new ObservableField<>();
    public final ObservableField<String> state = new ObservableField<>();
    public final ObservableField<String> stateAbbreviation = new ObservableField<>();
}
