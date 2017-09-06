package com.mooveit.fakeit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mooveit.fakeit.utils.Constants;
import com.mooveit.fakeit.utils.FragmentUtils;
import com.mooveit.library.Fakeit;

public class DataActivity extends AppCompatActivity {

    private static final String TAG = DataActivity.class.getCanonicalName();
    private static final String LAYOUT_EXTRAS = TAG + ":Layout:Layout";
    private static final String INIT_FRAGMENT = DataFragment.TAG;

    public static Intent getIntentWithExtras(int layout, Context context) {
        Intent intent = new Intent(context, DataActivity.class);
        intent.putExtra(LAYOUT_EXTRAS, layout);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_data);
        if (savedInstanceState == null) {
            initFragment();
        }
    }

    private void initFragment() {
        FragmentUtils.initFragment(this, DataFragment.newInstance(getLayoutExtra()), R.id.data_container, INIT_FRAGMENT);
    }

    private int getLayoutExtra() {
        return getIntent().getExtras().getInt(LAYOUT_EXTRAS);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.locales, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.unique_value):
                Fakeit.changeUniqueValueState();
                break;
            case (R.id.english):
                Fakeit.resetLocale(Constants.FakeitLocale.EN.locale());
                break;
            case (R.id.russian):
                Fakeit.resetLocale(Constants.FakeitLocale.RU.locale());
                break;
            case (R.id.spanish):
                Fakeit.resetLocale(Constants.FakeitLocale.ES.locale());
                break;
            case (R.id.german):
                Fakeit.resetLocale(Constants.FakeitLocale.DE.locale());
                break;
            case (R.id.catalan):
                Fakeit.resetLocale(Constants.FakeitLocale.CA.locale());
                break;
            case (R.id.persian):
                Fakeit.resetLocale(Constants.FakeitLocale.FA.locale());
                break;
            case (R.id.finnish):
                Fakeit.resetLocale(Constants.FakeitLocale.FI.locale());
                break;
            case (R.id.french):
                Fakeit.resetLocale(Constants.FakeitLocale.FR.locale());
                break;
            case (R.id.hebrew):
                Fakeit.resetLocale(Constants.FakeitLocale.HE.locale());
                break;
            case (R.id.indonesian):
                Fakeit.resetLocale(Constants.FakeitLocale.ID.locale());
                break;
            case (R.id.italian):
                Fakeit.resetLocale(Constants.FakeitLocale.IT.locale());
                break;
            case (R.id.japanese):
                Fakeit.resetLocale(Constants.FakeitLocale.JA.locale());
                break;
            case (R.id.korean):
                Fakeit.resetLocale(Constants.FakeitLocale.KO.locale());
                break;
            case (R.id.norwegian):
                Fakeit.resetLocale(Constants.FakeitLocale.NB.locale());
                break;
            case (R.id.dutch):
                Fakeit.resetLocale(Constants.FakeitLocale.NL.locale());
                break;
            case (R.id.polish):
                Fakeit.resetLocale(Constants.FakeitLocale.PL.locale());
                break;
            case (R.id.portuguese):
                Fakeit.resetLocale(Constants.FakeitLocale.PT.locale());
                break;
            case (R.id.slovak):
                Fakeit.resetLocale(Constants.FakeitLocale.SK.locale());
                break;
            case (R.id.swedish):
                Fakeit.resetLocale(Constants.FakeitLocale.SV.locale());
                break;
            case (R.id.turkish):
                Fakeit.resetLocale(Constants.FakeitLocale.TR.locale());
                break;
            case (R.id.ukrainian):
                Fakeit.resetLocale(Constants.FakeitLocale.UK.locale());
                break;
            case (R.id.vietnamese):
                Fakeit.resetLocale(Constants.FakeitLocale.VI.locale());
                break;
            case (R.id.chinese):
                Fakeit.resetLocale(Constants.FakeitLocale.ZH.locale());
                break;
            case android.R.id.home:
                super.onBackPressed();
        }

        recreate();

        return true;
    }
}