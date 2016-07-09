package com.swalloow.myeventbus.fragments;

import android.app.Fragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Junyoung on 2016-07-08.
 */

public class BaseFragment extends Fragment {
    /**
     * Handler for {@link }
     *
     * @param e
     * 		Event {@link  }.
     */
    public void onEvent(Object e) {

    }

    @Override
    public void onResume() {
        if (isStickyAvailable()) {
            // Deprecated
        } else {
            EventBus.getDefault().register(this);
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    /**
     * Is the {@link android.app.Fragment} ready to subscribe a sticky-event or not.
     *
     * @return {@code true} if the {@link android.app.Fragment}  available for sticky-events inc. normal events.
     * <p/>
     * <b>Default is {@code false}</b>.
     */
    protected boolean isStickyAvailable() {
        return false;
    }
}
