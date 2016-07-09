package com.swalloow.myeventbus.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.swalloow.myeventbus.R;
import com.swalloow.myeventbus.bus.StickyEvent;
import com.swalloow.myeventbus.bus.UpdateActionBarTitleEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Junyoung on 2016-07-08.
 */

public class ThirdFragment extends SecondFragment {
    @Override
    public void onEvent(StickyEvent _stickyEvent) {
        Button updateBtn = (Button) getView().findViewById(R.id.update_event_btn);
        updateBtn.setText(String.format("Override onEvent\n%s", _stickyEvent.getDataObject().toString()));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
		/*Update ActionBar's title.*/
        EventBus.getDefault().post(new UpdateActionBarTitleEvent(getString(R.string.screen_3)));
        View v = view.findViewById(R.id.update_event_btn);
        v.setEnabled(false);
        view.findViewById(R.id.next_btn).setVisibility(View.GONE);
    }
}
