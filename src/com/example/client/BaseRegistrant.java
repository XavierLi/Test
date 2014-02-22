package com.example.client;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.engine.EventManager;
import com.example.engine.EventObject;
import com.example.engine.util.AsyncResult;

public abstract class BaseRegistrant {
    protected static final String TAG = "BaseRegistrant";

    protected final int MSG_EVENT = 0;

    protected final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MSG_EVENT) {
                AsyncResult ar = (AsyncResult)msg.obj;
                handleEvent((EventObject)ar.result);
            } else {
                Log.w(TAG, "Unsupport message: " + msg.what);
            }
            super.handleMessage(msg);
        }
        
    };

    protected final Context mContext;

    public BaseRegistrant(Context context, EventManager manager) {
        mContext = context;
        manager.registerForEvent(mHandler, MSG_EVENT, null);
    }

    protected abstract void handleEvent(EventObject event);
}
