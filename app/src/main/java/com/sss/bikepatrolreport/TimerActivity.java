package com.sss.bikepatrolreport;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;
import static com.sss.bikepatrolreport.UtilSharedPreferences.*;

/**
 * Class TimerActivity.  Encapsulates Bike Patrol report timing functions
 */
public class TimerActivity extends AppCompatActivity
{
    private final static String TAG = "timerActivity";

    private final static Long   SEC_PER_HOUR = 3600L;
    private final static Long   SEC_PER_MIN  =   60L;
    private final static Long   MSEC_PER_SEC = 1000L;

    //private SharedPreferences.Editor mSharedPrefEditor;
    private UtilSharedPreferences    mSharedPreference;

    private EditText          mEditTextElapsed;
    //private SharedPreferences mSharedPreferences;

    /**
     * Implements the android lifecycle onCreate function
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Log.i(TAG, "onCreate()");

        // get access to persistent timer settings
        //mSharedPreferences = getDefaultSharedPreferences(getApplicationContext());
        //mSharedPrefEditor  = mSharedPreferences.edit();
        mSharedPreference  = new UtilSharedPreferences(getApplicationContext());
        mEditTextElapsed   = findViewById(R.id.et_elapsed_time);

        Button button_start = findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startTimer();
            }
        });

        Button button_stop = findViewById(R.id.button_stop);
        button_stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                stopTimer();
            }
        });

        // initialize display
        initializeDisplay();

        // start the update display thread
        updateAfterDelay();
    }   // end onCreate()


    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////// PRIVATE MEMBER FUNCTIONS /////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Initialize the timer display
     */
    private void initializeDisplay()
    {
        // initialize the start date
        Date             start_date  = new Date(getTimerStart());
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String           date_str    = date_format.format(start_date);
        EditText         et_start_date = findViewById(R.id.et_start_date);
        et_start_date.setText(date_str);

        // initialize the start time
        date_format = new SimpleDateFormat("hh:mm:ss a", Locale.US);
        String time_str = date_format.format(start_date);
        EditText et_start_time = findViewById(R.id.et_start_time);
        et_start_time.setText(time_str);

        // initialize the elapsed time
        updateTimerDisplay();

    }   // private void initializeDisplay()


    /**
     * Update the time display after a specified delay
     */
    private void updateAfterDelay()
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                // update the display after 500ms
                updateTimerDisplay();
            }
        }, 500);
    }


    /**
     * Update the timer display
     */
    private void updateTimerDisplay()
    {
        Log.i(TAG, "updateTimerDisplay()");

        Long    elap_secs;
        Long    timer_curr;
        Long    timer_start = getTimerStart();
        boolean timer_state = getTimerState();

        if(timer_state)
        {
            // here the timer is running
            timer_curr  = (new Date()).getTime();
            elap_secs   = (timer_curr - timer_start) / 1000;
        }
        else
        {
            // here the timer is not running
            timer_curr = getTimerStop();
            elap_secs  = (timer_curr - timer_start) / 1000;
        }

        mEditTextElapsed.setText(formatElapsedTime(elap_secs));
        Log.i(TAG, "Timer: state = " + timer_state +
                   ", start = "      + (timer_start / 1000) +
                   ", current = "    + (timer_curr / 1000)  +
                   ", elapsed = "    + elap_secs);

        updateAfterDelay();
    }   // end private void updateTimerDisplay()


    /**
     * Formats the elapsed time string to the format hh::mm:ss
     * @param elapsedTimeSec elapsed time in seconds to format
     * @return formatted time string
     */
    private String formatElapsedTime(Long elapsedTimeSec)
    {
        Long elap_hours = elapsedTimeSec / SEC_PER_HOUR;
        Long remain_sec = elapsedTimeSec % SEC_PER_HOUR;
        Long elap_min   = remain_sec     / SEC_PER_MIN;
        Long elap_sec   = remain_sec     % SEC_PER_MIN;

        return String.format(Locale.US, "%02d:%02d:%02d",
                elap_hours, elap_min, elap_sec);
    }


    /**
     * Starts the timer if its not already running.
     */
    private void startTimer()
    {
        if(getTimerState())
        {
            // timer is running, don't do anything
            Toast.makeText(this, "Timer is Already Running", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // timer is not running, start it
            Toast.makeText(this, "Starting Timer", Toast.LENGTH_SHORT).show();
            long time_stamp = (new Date()).getTime();
            setTimerStart(time_stamp);
            setTimerState(true);
            initializeDisplay();
        }
    }


    /**
     * Stops the timer if its running
     */
    private void stopTimer ()
    {


        if(getTimerState())
        {
            // timer is running, stop the timer
            Toast.makeText(this, "Stopping Timer", Toast.LENGTH_SHORT).show();
            long time_stamp = (new Date()).getTime();
            setTimerStop(time_stamp);
            setTimerState(false);
        }
        else
        {
            // timer is not running don't do anything
            Toast.makeText(this, "Timer is Not Running", Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * Get current state of timer: running or not.
     * @return true if the timer is running, false otherwise
     */
    private boolean getTimerState()
    {
        return mSharedPreference.getBoolean(PATROL_TIMER_STATE, false);
    }


    /**
     * Sets current state of timer: running or not.  This value is written to
     * persistence storage.
     * @param timerState true if the timer is running, false otherwise
     */
    private void setTimerState(boolean timerState)
    {
        mSharedPreference.putBoolean(PATROL_TIMER_STATE, timerState);
    }


    /**
     * Get the timer start timestamp from persistence.  This value is the
     * number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return timer start time
     */
    private long getTimerStart()
    {
        long default_start = new Date().getTime();
        return mSharedPreference.getLong(PATROL_TIMER_START, default_start);
    }


    /**
     * Set the timer start timestamp in persistence.  This value should be the
     * number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return timer start time
     */
    private void setTimerStart(long timerStart)
    {
        mSharedPreference.putLong(PATROL_TIMER_START, timerStart);
    }


    /**
     * Get the timer stop timestamp from persistence.  This value is the
     * number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return timer start time
     */
    private long getTimerStop()
    {
        return mSharedPreference.getLong(PATROL_TIMER_STOP, 0);
    }


    /**
     * Set the timer stop timestamp in persistence.  This value should be the
     * number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return timer start time
     */
    private void setTimerStop(long timerStop)
    {
        mSharedPreference.putLong(PATROL_TIMER_STOP, timerStop);
    }


    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////// INTERNAL CLASSES /////////////////////////////
    ////////////////////////////////////////////////////////////////////////////


}   // end public class TimerActivity extends AppCompatActivity
