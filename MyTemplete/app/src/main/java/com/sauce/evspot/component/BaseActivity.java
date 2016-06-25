package com.sauce.evspot.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Junyoung on 2016-06-26.
 */

public abstract class BaseActivity extends AppCompatActivity {
    // 모든 액티비티가 상속받는 공통 액티비티
    // 공통 처리과정이 필요하거나 나만의 LifeCycle을 만들어 관리

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLaunchParam(getIntent());
    }

    protected abstract void loadLaunchParam(Intent i);
}