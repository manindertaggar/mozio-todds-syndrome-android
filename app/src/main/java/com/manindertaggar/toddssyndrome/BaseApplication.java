package com.manindertaggar.toddssyndrome;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;

import com.manindertaggar.toddssyndrome.storage.Dao;
import com.manindertaggar.toddssyndrome.storage.Pref;

/**
 * Created by maninder on 16/7/17.
 */

public class BaseApplication extends Application {
    public static Context context;

    public static String getDeviceId() {
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        Pref.init(this);
        Dao.init(this);
    }
}
