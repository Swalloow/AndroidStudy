package com.sauce.evspot.component;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.sauce.evspot.R;

/**
 * Created by Junyoung on 2016-06-26.
 */
public class IntroActivity extends BaseActivity {
    private static int INTRO_TIME = 3000;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, INTRO_TIME);

        TextView title = (TextView) findViewById(R.id.textTitle);
        TextView subTitle = (TextView) findViewById(R.id.textSubTitle);
    }

    @Override
    protected void loadLaunchParam(Intent i) { }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            Intent i = HomeActivity.getIntent(IntroActivity.this, "Kimss");
            startActivity(i);
            finish();
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mHandler.removeCallbacks(mRunnable);
    }
}
