package com.example.client;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import com.example.engine.EventManager;
import com.example.engine.EventObject;

public class DialogRegistrant extends BaseRegistrant implements DialogInterface.OnClickListener {
    protected static final String TAG = "DialogRegistrant";

    public DialogRegistrant(Context context, EventManager manager) {
        super(context, manager);
    }

    @Override
    protected void handleEvent(EventObject event) {
        Log.d(TAG, "New event: " + event.getTitle() + " (" + event.getEvent() + ")");

        Intent intent = new Intent(mContext, DialogActivity.class);
        intent.putExtra(DialogActivity.EXTRA_TITLE, event.getTitle());
        intent.putExtra(DialogActivity.EXTRA_EVENT, event.getEvent());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        mContext.startActivity(intent);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

}
