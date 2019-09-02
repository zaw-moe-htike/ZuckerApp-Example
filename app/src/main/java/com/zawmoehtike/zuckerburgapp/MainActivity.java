package com.zawmoehtike.zuckerburgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;

public class MainActivity extends AppCompatActivity {

    private AppEventsLogger logger;

    private Button mBtnSearch;
    private EditText mEtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logger = AppEventsLogger.newLogger(this);

        mBtnSearch = findViewById(R.id.btnSearch);
        mEtSearch = findViewById(R.id.etSearch);

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textFromEtSearch = mEtSearch.getText().toString();

                Log.d("MainActivityLogger", textFromEtSearch);

                logSearchedEvent("Search", textFromEtSearch, true);
            }
        });
    }

    public void logSearchedEvent (String contentType, String searchString, boolean success) {
        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, contentType);
        params.putString(AppEventsConstants.EVENT_PARAM_SEARCH_STRING, searchString);
        params.putInt(AppEventsConstants.EVENT_PARAM_SUCCESS, success ? 1 : 0);
        logger.logEvent(AppEventsConstants.EVENT_NAME_SEARCHED, params);
    }
}
