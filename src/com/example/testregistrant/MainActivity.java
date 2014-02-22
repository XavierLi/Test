package com.example.testregistrant;

import com.example.engine.EventManager;
import com.example.engine.EventObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    private EventManager mEventManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.message_1).setOnClickListener(this);
        findViewById(R.id.message_2).setOnClickListener(this);
        findViewById(R.id.message_3).setOnClickListener(this);

        mEventManager = EventManager.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.message_1:
            mEventManager.notifyEvent(new EventObject(getString(R.string.message_1),
                    getString(R.string.message_1_content)));
            return;
        case R.id.message_2:
            mEventManager.notifyEvent(new EventObject(getString(R.string.message_2),
                    getString(R.string.message_2_content)));
            return;
        case R.id.message_3:
            mEventManager.notifyEvent(new EventObject(getString(R.string.message_3),
                    getString(R.string.message_3_content)));
            return;
        }
    }

}
