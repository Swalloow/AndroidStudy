package com.sauce.evspot.component;

import android.app.Application;

import com.sauce.evspot.datasource.db.DbApi;
import com.sauce.evspot.datasource.preference.PreferenceApi;

/**
 * Created by Junyoung on 2016-06-26.
 */

public class EVSpotApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 앱의 전체 LifeCycle과 동일하게 동작해야 하는 부분이 있다면
        // Application 영역에서 초기화
        PreferenceApi.createInstance(this);
        DbApi.createInstance(this);
    }
}
