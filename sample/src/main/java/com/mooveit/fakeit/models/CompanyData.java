package com.mooveit.fakeit.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class CompanyData extends BaseObservable {

    public final ObservableField<String> companySuffix = new ObservableField<>();
    public final ObservableField<String> companyBuzzwords = new ObservableField<>();
    public final ObservableField<String> companyBs = new ObservableField<>();
    public final ObservableField<String> companyName = new ObservableField<>();
    public final ObservableField<String> companyIndustry = new ObservableField<>();
    public final ObservableField<String> companyProfession = new ObservableField<>();
}