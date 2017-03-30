package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class HeyArnoldData extends BaseObservable {

    public final ObservableField<String> heyArnoldCharacter = new ObservableField<>();
    public final ObservableField<String> heyArnoldLocation = new ObservableField<>();
    public final ObservableField<String> heyArnoldQuote = new ObservableField<>();
}
