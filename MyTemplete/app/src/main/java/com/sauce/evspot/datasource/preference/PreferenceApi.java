package com.sauce.evspot.datasource.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Junyoung on 2016-06-26.
 */

public class PreferenceApi {
    private static PreferenceApi sInstance = null;
    private Context mContext = null;
    private static final String PREFERENCE_NAME = "preference";

    // Keyset
    private static final String KEY_PREF_EXAMPLE = "KEY_PREF_EXAMPLE";

    public PreferenceApi(Context mContext) {
        this.mContext = mContext;
    }

    public static PreferenceApi getsInstance() {
        return sInstance;
    }

    // Singleton instance 생성
    public static PreferenceApi createInstance(Context context) {
        if (sInstance == null) {
            synchronized (PreferenceApi.class) {
                if (sInstance == null) {
                    sInstance = new PreferenceApi(context);
                }
            }
        }
        return sInstance;
    }

    // Test Method

    public void setExample(int value) {
        set(PREFERENCE_NAME, KEY_PREF_EXAMPLE, value);
    }
    public int getExample() {
        return getInt(PREFERENCE_NAME, KEY_PREF_EXAMPLE, -1);
    }

    private void set(String name, String key, boolean value) {
        SharedPreferences pref = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    private void set(String name, String key, int value) {
        SharedPreferences pref = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private void set(String name, String key, long value) {
        SharedPreferences pref = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    private void set(String name, String key, String value) {
        boolean result;
        SharedPreferences pref = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private boolean getBoolean(String name, String key, boolean bDefault) {
        SharedPreferences pref = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return pref.getBoolean(key, bDefault);
    }

    private int getInt(String name, String key, int nDefault) {
        SharedPreferences pref = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return pref.getInt(key, nDefault);
    }

    private long getLong(String name, String key, long nDefault) {
        SharedPreferences pref = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return pref.getLong(key, nDefault);
    }

    private String getString(String name, String key, String strDefault) {
        SharedPreferences pref = mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return pref.getString(key, strDefault);
    }
}
