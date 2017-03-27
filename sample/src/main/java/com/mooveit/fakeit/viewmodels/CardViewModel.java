package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.CardData;
import com.mooveit.library.Fakeit;

public class CardViewModel extends BaseViewModel {

    private CardData mData;

    public CardViewModel(CardData data) {
        this.mData = data;
        setCardData();
    }

    public CardData getData() {
        return mData;
    }

    private void setCardData() {
        mData.name.set(Fakeit.card().name());
        mData.brand.set(Fakeit.card().brand());
        mData.number.set(Fakeit.card().number());
        mData.type.set(Fakeit.card().type());
        mData.expirationDate.set(Fakeit.card().expirationDate());
    }

    @Override
    public void refresh() {
        setCardData();
    }
}