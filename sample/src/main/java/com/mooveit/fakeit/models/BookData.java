package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class BookData extends BaseObservable {

    public final ObservableField<String> bookTitle = new ObservableField<>();
    public final ObservableField<String> bookAuthor = new ObservableField<>();
    public final ObservableField<String> bookPublisher = new ObservableField<>();
    public final ObservableField<String> bookGenre = new ObservableField<>();
}
