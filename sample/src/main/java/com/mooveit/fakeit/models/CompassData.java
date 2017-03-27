package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class CompassData extends BaseObservable {

    public final ObservableField<String> compassCardinal = new ObservableField<>();
    public final ObservableField<String> compassOrdinal = new ObservableField<>();
    public final ObservableField<String> compassHalfWind = new ObservableField<>();
    public final ObservableField<String> compassQuarterWind = new ObservableField<>();
    public final ObservableField<String> compassDirection = new ObservableField<>();
    public final ObservableField<String> compassAbbreviation = new ObservableField<>();
    public final ObservableField<String> compassAzimuth = new ObservableField<>();
    public final ObservableField<String> compassCardinalAbbreviation = new ObservableField<>();
    public final ObservableField<String> compassOrdinalAbbreviation = new ObservableField<>();
    public final ObservableField<String> compassHalfWindAbbreviation = new ObservableField<>();
    public final ObservableField<String> compassQuarterWindAbbreviation = new ObservableField<>();
    public final ObservableField<String> compassCardinalAzimuth = new ObservableField<>();
    public final ObservableField<String> compassOrdinalAzimuth = new ObservableField<>();
    public final ObservableField<String> compassHalfWindAzimuth = new ObservableField<>();
    public final ObservableField<String> compassQuarterWindAzimuth = new ObservableField<>();
}