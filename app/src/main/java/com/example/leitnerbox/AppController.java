package com.example.leitnerbox;

import android.app.Application;
import com.example.leitnerbox.database.MyObjectBox;
import io.objectbox.BoxStoreBuilder;
import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class AppController extends Application {

    private static BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        setupDefaultFont();

        initObjectBox();

    }

    private void initObjectBox() {
        BoxStoreBuilder boxStoreBuilder = MyObjectBox.builder().androidContext(AppController.this);
        boxStore = boxStoreBuilder.build();

        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(boxStore).start(this);
        }

    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }

    private void setupDefaultFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iran_sans_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}