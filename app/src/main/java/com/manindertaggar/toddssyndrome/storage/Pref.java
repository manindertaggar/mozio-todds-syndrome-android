package com.manindertaggar.toddssyndrome.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Maninder Taggar on 25/6/17.
 */

public class Pref {
    private static final String KEY_LOGGED_IN = "isLoggedIn";
    private static final String KEY_DEVICE_ID = "deviceId";
    private static final String KEY_NAME = "name";

    private static Pref runningInstance;
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public Pref(Context context) {
        if (runningInstance != null)
            return;
        this.context = context;
        this.runningInstance = this;
        sharedPreferences = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static Pref getInstance() {
        return runningInstance;
    }

    public static void init(Context context) {
        new Pref(context);
    }

    public Boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_LOGGED_IN, false);
    }

    public void setIsLoggedIn(Boolean value) {
        editor.putBoolean(KEY_LOGGED_IN, value).commit();
    }

    public void saveDeviceId(String token) {
        if (token != null || !token.isEmpty()) {
            editor.putString(KEY_DEVICE_ID, token).commit();
            setIsLoggedIn(true);
        } else {
            editor.remove(KEY_DEVICE_ID);
            setIsLoggedIn(false);
        }
    }

    public void clearToken() {
        saveDeviceId(null);
    }

    public String getToken() {
        return sharedPreferences.getString(KEY_DEVICE_ID, "");
    }

    public String getName() {
        return sharedPreferences.getString(KEY_NAME, "");
    }

    public void setName(String name) {
        editor.putString(KEY_NAME, name).commit();
    }

}
