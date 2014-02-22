package com.example.engine;

import android.os.Handler;

import com.example.engine.util.Registrant;
import com.example.engine.util.RegistrantList;

public class EventManager {

    private static EventManager mInstance;

    private RegistrantList mEventRegistrants = new RegistrantList();

    public static EventManager getInstance() {
        if (mInstance == null) {
            mInstance = new EventManager();
        }
        return mInstance;
    }

    private EventManager() {
        
    }

    public void registerForEvent(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);
        mEventRegistrants.add(r);
    }

    public void unregisterForEvent(Handler h) {
        mEventRegistrants.remove(h);
    }

    public void notifyEvent(EventObject obj) {
        mEventRegistrants.notifyResult(obj);
    }
}
