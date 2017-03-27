package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.CompassData;
import com.mooveit.library.Fakeit;

public class CompassViewModel extends BaseViewModel {

    private CompassData mData;

    public CompassViewModel(CompassData data) {
        this.mData = data;
        setBusinessData();
    }

    public CompassData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.compassCardinal.set(Fakeit.compass().cardinal());
        mData.compassOrdinal.set(Fakeit.compass().ordinal());
        mData.compassHalfWind.set(Fakeit.compass().half_wind());
        mData.compassQuarterWind.set(Fakeit.compass().quarter_wind());
        mData.compassDirection.set(Fakeit.compass().direction());
        mData.compassAbbreviation.set(Fakeit.compass().abbreviation());
        mData.compassAzimuth.set(Fakeit.compass().azimuth());
        mData.compassCardinalAbbreviation.set(Fakeit.compass().cardinal_abbreviation());
        mData.compassOrdinalAbbreviation.set(Fakeit.compass().ordinal_abbreviation());
        mData.compassHalfWindAbbreviation.set(Fakeit.compass().half_wind_abbreviation());
        mData.compassQuarterWindAbbreviation.set(Fakeit.compass().quarter_wind_abbreviation());
        mData.compassCardinalAzimuth.set(Fakeit.compass().cardinal_azimuth());
        mData.compassOrdinalAzimuth.set(Fakeit.compass().ordinal_azimuth());
        mData.compassHalfWindAzimuth.set(Fakeit.compass().half_wind_azimuth());
        mData.compassQuarterWindAzimuth.set(Fakeit.compass().quarter_wind_azimuth());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}