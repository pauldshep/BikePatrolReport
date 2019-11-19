package com.sss.bikepatrolreport;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.sss.bikepatrolreport.UtilSharedPreferences.CONFIG_EMAIL;
import static com.sss.bikepatrolreport.UtilSharedPreferences.SEEN_NUM_HIKERS;

public class ActivityAppSettings extends AppCompatActivity
{
    private UtilSharedPreferences mSharedPreference;

    private EditText mEmailAddr;

    /**
     * Android Life cycle function onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);
        getSupportActionBar().setTitle(R.string.settings_action_bar_title);
        mSharedPreference = new UtilSharedPreferences(getApplicationContext());

        mEmailAddr = findViewById(R.id.et_email_addr);

        Button btn_use = findViewById(R.id.btn_use_settings);
        btn_use.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                useAppSettings();
            }
        });

        getAppSettings();
    }   // end protected void onCreate(Bundle savedInstanceState)


    /**
     * Get general activity settings from shared preferences
     */
    private void getAppSettings()
    {
        mEmailAddr.setText(mSharedPreference.getString(CONFIG_EMAIL, "pauldshep@gmail.com"));
    }

    /**
     * Saves the app current app settings defined in this dialog
     */
    private void useAppSettings()
    {
        mSharedPreference.putString(CONFIG_EMAIL, mEmailAddr.getText().toString());
    }

}   // end public class ActivityAppSettings extends AppCompatActivity
