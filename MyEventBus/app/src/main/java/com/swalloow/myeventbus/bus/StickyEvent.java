package com.swalloow.myeventbus.bus;

import com.swalloow.myeventbus.dto.DataObject;

/**
 * Created by Junyoung on 2016-07-08.
 */
public class StickyEvent {

    private DataObject mDataObject;

    public StickyEvent(DataObject _dataObject) {
        mDataObject = _dataObject;
    }

    public DataObject getDataObject() {
        return mDataObject;
    }
}
