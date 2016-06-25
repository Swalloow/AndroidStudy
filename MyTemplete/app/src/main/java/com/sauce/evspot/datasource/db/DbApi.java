package com.sauce.evspot.datasource.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Junyoung on 2016-06-26.
 */

public class DbApi {
    private static DbApi sInstance;
    private SQLiteDatabase db;

    private DbApi(Context context) {
        DbHelper dbOpenHelper = new DbHelper(context);
        db = dbOpenHelper.getWritableDatabase();
    }

    // Singleton instance 생성
    public static void createInstance(Context mContext) {
        if(sInstance == null) {
            synchronized (DbApi.class) {
                if(sInstance == null) {
                    sInstance = new DbApi(mContext);
                }
            }
        }
    }

    public static DbApi getInstance() {
        return sInstance;
    }
}
