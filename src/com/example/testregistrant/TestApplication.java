package com.example.testregistrant;

import com.example.client.DialogRegistrant;
import com.example.client.NotificationRegistrant;
import com.example.engine.EventManager;

import android.app.Application;
import android.content.Context;

public class TestApplication extends Application {
    private DialogRegistrant mDialogRegistrant;
    private NotificationRegistrant mNotificationRegistrant;

    @Override
    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
        EventManager manager = EventManager.getInstance();

        mDialogRegistrant = new DialogRegistrant(context, manager);
        mNotificationRegistrant = new NotificationRegistrant(context, manager);
    }

}
