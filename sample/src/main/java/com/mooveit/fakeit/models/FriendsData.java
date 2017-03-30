package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class FriendsData extends BaseObservable {

    public final ObservableField<String> friendsCharacter = new ObservableField<>();
    public final ObservableField<String> friendsLocation = new ObservableField<>();
    public final ObservableField<String> friendsQuote = new ObservableField<>();
}
