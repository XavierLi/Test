package com.example.client;

import com.example.testregistrant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class DialogActivity extends Activity implements View.OnClickListener {
    protected static final String TAG = "DialogActivity";

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_EVENT = "event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.btn_ok).setOnClickListener(this);
        TextView text = (TextView)findViewById(R.id.message);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(EXTRA_TITLE);
            if (!TextUtils.isEmpty(title)) {
                setTitle(title);
            }

            String message = intent.getStringExtra(EXTRA_EVENT);
            if (!TextUtils.isEmpty(message)) {
                text.setText(message);
            }
        }

        setFinishOnTouchOutside(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
