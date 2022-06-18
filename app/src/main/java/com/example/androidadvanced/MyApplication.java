package com.example.androidadvanced;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.androidadvanced.managers.LocaleManager;

import timber.log.Timber;

/**
 * Created by Eldor Turgunov on 18.06.2022.
 * Android Advanced
 * eldorturgunov777@gmail.com
 */
public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();
    public static LocaleManager localeManager;

    @Override
    public void onCreate() {
        super.onCreate();
        localeManager = new LocaleManager(this);
        localeManager.setLocale(this);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeManager.setLocale(this);
        Timber.tag(TAG).d("onConfigurationChanged: %s", newConfig.locale.getLanguage());
    }
}
