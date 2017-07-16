package com.manindertaggar.toddssyndrome.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Maninder Taggar on 25/6/17.
 */

public class Pref {
    private static final String KEY_IS_DATA_SYNCED_ATLEASE_ONCE = "isDataSyncedAtleastOnce";

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

    public Boolean isDataSyncedAtleastOnce() {
        return sharedPreferences.getBoolean(KEY_IS_DATA_SYNCED_ATLEASE_ONCE, false);
    }

    public void setDataSynced(Boolean value) {
        editor.putBoolean(KEY_IS_DATA_SYNCED_ATLEASE_ONCE, value).commit();
    }


}
