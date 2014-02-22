package com.example.engine;

public class EventObject {
    private String mTitle;
    private String mEvent;

    public EventObject(String title, String event) {
        mTitle = title;
        mEvent = event;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getEvent() {
        return mEvent;
    }
}
