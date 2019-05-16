package com.example.leitnerbox;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupDefaultFont();



    }

    private void setupDefaultFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iran_sans_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}