package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.ESportData;
import com.mooveit.library.Fakeit;

public class ESportViewModel extends BaseViewModel {

    private ESportData mData;

    public ESportViewModel(ESportData data) {
        this.mData = data;
        setBusinessData();
    }

    public ESportData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.player.set(Fakeit.esports().player());
        mData.team.set(Fakeit.esports().team());
        mData.league.set(Fakeit.esports().league());
        mData.event.set(Fakeit.esports().event());
        mData.game.set(Fakeit.esports().game());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}