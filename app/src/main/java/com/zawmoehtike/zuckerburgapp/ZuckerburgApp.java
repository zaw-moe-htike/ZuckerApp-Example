package com.zawmoehtike.zuckerburgapp;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class ZuckerburgApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * This function assumes logger is an instance of AppEventsLogger and has been
         * created using AppEventsLogger.newLogger() call.
         */
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
