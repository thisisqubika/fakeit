package com.mooveit.fakeit.utils;

import android.app.Activity;
import android.app.Fragment;

public class FragmentUtils {

    public static void initFragment(Activity activity, Fragment fragment, int layout, String tag) {
        activity.getFragmentManager().beginTransaction().add(layout, fragment, tag).commit();
    }
}
