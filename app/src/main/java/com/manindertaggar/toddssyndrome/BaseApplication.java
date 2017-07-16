package com.manindertaggar.toddssyndrome;

import android.app.Application;

import com.manindertaggar.toddssyndrome.storage.Dao;
import com.manindertaggar.toddssyndrome.storage.Pref;

/**
 * Created by maninder on 16/7/17.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Dao.init(this);
        Pref.init(this);
    }
}
