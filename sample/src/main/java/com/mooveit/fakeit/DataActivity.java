package com.mooveit.fakeit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mooveit.fakeit.utils.FragmentUtils;

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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}