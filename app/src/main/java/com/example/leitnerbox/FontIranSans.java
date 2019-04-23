package com.example.leitnerbox;

import android.app.Application;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class FontIranSans extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iran_sans_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
