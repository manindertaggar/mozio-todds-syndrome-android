package com.manindertaggar.toddssyndrome.storage;

import android.content.Context;

import com.manindertaggar.toddssyndrome.DaoMaster;
import com.manindertaggar.toddssyndrome.DaoSession;
import com.manindertaggar.toddssyndrome.SyndromTestDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Maninder Taggar on 26/6/17.
 */

public class Dao {
    private static DaoSession daoSession;

    public static void init(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, context.getPackageName());
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }

    public static SyndromTestDao getSyndromeDao() {
        return daoSession.getSyndromTestDao();
    }

}
