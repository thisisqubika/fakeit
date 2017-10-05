package com.mooveit.fakeit.viewmodels;

import com.mooveit.fakeit.R;

public class MainViewModel {

    public interface MainCallback {

        void startActivityWithLayout(int layout);
    }

    private final MainCallback mMainCallback;

    public MainViewModel(MainCallback mMainCallback) {
        this.mMainCallback = mMainCallback;
    }

    public void onAddressClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_address);
    }

    public void onAncientClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_ancient);
    }

    public void onBusinessClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_business);
    }

    public void onCardClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_card);
    }

    public void onNameClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_name);
    }

    public void onAppClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_app);
    }

    public void onArtistClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_artist);
    }

    public void onBankClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_bank);
    }

    public void onBeerClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_beer);
    }

    public void onBookClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_book);
    }

    public void onCatClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_cat);
    }

    public void onChuckNorrisClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_chuck_norris_facts);
    }

    public void onCodeClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_code);
    }

    public void onCoffeeClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_coffee);
    }

    public void onCompanyClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_company);
    }

    public void onCompassClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_compass);
    }

    public void onDemographicClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_demographic);
    }

    public void onDateTimeClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_date_time);
    }

    public void onEducatorClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_educator);
    }

    public void onESportClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_esport);
    }

    public void onFileClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_file);
    }

    public void onFoodClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_food);
    }

    public void onFriendsClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_friends);
    }

    public void onGameOfThronesClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_game_of_thrones);
    }

    public void onHackerClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_hacker);
    }

    public void onHarryPotterClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_harry_potter);
    }

    public void onHeyArnoldClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_hey_arnold);
    }

    public void onHipsterClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_hipster);
    }

    public void onInternetClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_internet);
    }

    public void onJobClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_job);
    }

    public void onLordOfTheRingsClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_lord_of_the_rings);
    }

    public void onLoremClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_lorem);
    }

    public void onMusicClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_music);
    }

    public void onPhoneNumberClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_phone_number);
    }

    public void onPokemonClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_pokemon);
    }

    public void onRickAndMortyClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_rick_and_morty);
    }

    public void onRockBandClick() {
        mMainCallback.startActivityWithLayout(R.layout.fragment_rock_band);
    }
}