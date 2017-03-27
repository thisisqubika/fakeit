package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class FileData extends BaseObservable {

    public final ObservableField<String> extension = new ObservableField<>();
    public final ObservableField<String> mimeType = new ObservableField<>();
}
