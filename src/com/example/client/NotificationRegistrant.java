package com.example.client;

import com.example.engine.EventManager;
import com.example.engine.EventObject;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NotificationRegistrant extends BaseRegistrant {
    protected static final String TAG = "NotificationRegistrant";

    private NotificationManager mNotificationManager;

    public NotificationRegistrant(Context context, EventManager manager) {
        super(context, manager);

        mNotificationManager = (NotificationManager)mContext.getSystemService(
                Context.NOTIFICATION_SERVICE);
    }

    @Override
    protected void handleEvent(EventObject event) {
        Log.d(TAG, "New event: " + event.getTitle() + " (" + event.getEvent() + ")");

        Intent intent = new Intent(mContext, DialogActivity.class);
        intent.putExtra(DialogActivity.EXTRA_TITLE, event.getTitle());
        intent.putExtra(DialogActivity.EXTRA_EVENT, event.getEvent());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent contentIntent = PendingIntent.getActivity(mContext, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new  Notification.Builder(mContext);
        builder.setSmallIcon(R.drawable.stat_notify_error);
        builder.setWhen(System.currentTimeMillis());
        builder.setTicker(event.getTitle());
        builder.setContentTitle(event.getTitle());
        builder.setContentText(event.getEvent());
        builder.setContentIntent(contentIntent);
        builder.setAutoCancel(true);

        mNotificationManager.notify(0, builder.getNotification());
    }
}
