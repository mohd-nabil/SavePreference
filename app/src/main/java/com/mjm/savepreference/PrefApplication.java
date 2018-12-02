package com.mjm.savepreference;

import android.app.Application;
import android.content.ContextWrapper;

/**
 * Created by nabilulaleem.md on 15-06-2018.
 */
public class PrefApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new Preference.Builder()
                .setContext(this)
                .setPrefName("MyPrefName")
                .setMode(ContextWrapper.MODE_PRIVATE)
                .build();
    }
}
