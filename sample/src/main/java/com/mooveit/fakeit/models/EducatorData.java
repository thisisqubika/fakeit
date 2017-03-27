package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class EducatorData extends BaseObservable {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> secondary = new ObservableField<>();
    public final ObservableField<String> tertiaryType = new ObservableField<>();
    public final ObservableField<String> tertiaryCourseSubject = new ObservableField<>();
    public final ObservableField<String> tertiaryCourseType = new ObservableField<>();
}
