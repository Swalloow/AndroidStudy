package com.swalloow.myeventbus.fragments;

/**
 * Created by Junyoung on 2016-07-08.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.swalloow.myeventbus.R;
import com.swalloow.myeventbus.bus.MoveToFragmentEvent;
import com.swalloow.myeventbus.bus.NormalEvent;
import com.swalloow.myeventbus.bus.StickyEvent;
import com.swalloow.myeventbus.bus.UpdateActionBarTitleEvent;
import com.swalloow.myeventbus.dto.DataObject;

import org.greenrobot.eventbus.EventBus;


public class SecondFragment extends BaseFragment {
    private static final int LAYOUT = R.layout.fragment_second;

    /**
     * Handler for {@link StickyEvent}
     *
     * @param e
     * 		Event {@link StickyEvent}.
     */
    public void onEvent(StickyEvent e) {
        Toast.makeText(getActivity(), String.format("Sticky handler: %s", e.getDataObject().toString()), Toast.LENGTH_SHORT).show();
    }

    /**
     * Handler for {@link com.swalloow.myeventbus.bus.NormalEvent}
     *
     * @param e
     * 		Event {@link  com.swalloow.myeventbus.bus.NormalEvent}.
     */
    public void onEvent(NormalEvent e) {
        Toast.makeText(getActivity(), R.string.msg_normal_event, Toast.LENGTH_SHORT).show();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		/*Update ActionBar's title.*/
        EventBus.getDefault().post(new UpdateActionBarTitleEvent(getString(R.string.screen_2)));
        return inflater.inflate(LAYOUT, container, false);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.normal_event_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new NormalEvent());
            }
        });

        view.findViewById(R.id.update_event_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				/*Update the sticky, LOOK the postSticky() runs including post() that onEvent(StickyEvent e) will be called late.*/
                DataObject to = new DataObject("XinyueZ", "dev.xinyue.zhao@gmail.com");
                StickyEvent newEvent = new StickyEvent(to);
                EventBus.getDefault().postSticky(newEvent);
                Toast.makeText(getActivity(), "New Sticky is posted.", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.next_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				/*Move to 3rd fragment.*/
                EventBus.getDefault().post(new MoveToFragmentEvent(new ThirdFragment()));
            }
        });
    }

    @Override
    protected boolean isStickyAvailable() {
        return true;
    }
}
