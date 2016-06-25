package com.sauce.evspot.datasource.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Junyoung on 2016-06-26.
 */

public class DbHelper extends SQLiteOpenHelper {
    private final static String DB_FILE_NAME = "EV_SPOT.db";
    private final static int VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_FILE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Table 생성 쿼리문
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 앱이 업데이트 됨에 따라 로컬 DB 업데이트가 필요할 경우 쿼리문
    }
}
