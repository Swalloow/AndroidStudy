package com.swalloow.myeventbus.bus;

/**
 * Created by Junyoung on 2016-07-08.
 */
public class UpdateActionBarTitleEvent {

    /**
     * Title for {@link android.app.ActionBar}.
     */
    private String mTitle;

    /**
     * Constructor of {@link UpdateActionBarTitleEvent}.
     *
     * @param _title
     * 		Title for {@link android.app.ActionBar}.
     */
    public UpdateActionBarTitleEvent(String _title) {
        mTitle = _title;
    }

    /**
     * Get title for {@link android.app.ActionBar}.
     *
     * @return Title for {@link android.app.ActionBar}.
     */
    public String getTitle() {
        return mTitle;
    }
}
