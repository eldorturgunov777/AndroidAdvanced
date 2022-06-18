package com.example.androidadvanced.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Eldor Turgunov on 18.06.2022.
 * Android Advanced
 * eldorturgunov777@gmail.com
 */
public class PrefsManager {
    private static PrefsManager prefsManager;
    private final SharedPreferences sharedPreferences;

    public static PrefsManager getInstance(Context context) {
        if (prefsManager == null) {
            prefsManager = new PrefsManager(context);
        }
        return prefsManager;
    }
    private PrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public String getData(String key) {
        if (sharedPreferences != null)
            return sharedPreferences.getString(key, "");
        return "en";
    }

    public void clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
