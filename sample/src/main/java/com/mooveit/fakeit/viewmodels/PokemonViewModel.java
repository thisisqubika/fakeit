package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.models.PokemonData;
import com.mooveit.library.Fakeit;

public class PokemonViewModel extends BaseViewModel {

    private PokemonData mData;

    public PokemonViewModel(PokemonData data) {
        this.mData = data;
        setBusinessData();
    }

    public PokemonData getData() {
        return mData;
    }

    private void setBusinessData() {
        mData.pokemonName.set(Fakeit.pokemon().name());
        mData.pokemonLocation.set(Fakeit.pokemon().location());
    }

    @Override
    public void refresh() {
        setBusinessData();
    }
}