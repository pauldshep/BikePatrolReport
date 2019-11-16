package com.sss.bikepatrolreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Class TimerActivity.  Encapsulates Bike Patrol report timing functions
 */
public class TimerActivity extends AppCompatActivity
{
    private final static String TAG = "timerActivity";

    private final static String PATROL_TIMER_STATE = "patrol_timer_state";
    private final static String PATROL_TIMER_START = "patrol_timer_start";
    private final static String PATROL_TIMER_STOP  = "patrol_timer_stop";

    private SharedPreferences.Editor mSharedPrefEditor;

    private EditText mEditTextElapsed;

    /**
     * Implements the android lifecycle onCreate function
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        // get access to persistent timer settings
        Context           app_context = getApplicationContext();
        SharedPreferences shared_pref = getDefaultSharedPreferences(app_context);
        mSharedPrefEditor             = shared_pref.edit();

        mEditTextElapsed = findViewById(R.id.editText_elapsed_time);

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

        // start the update display thread
        new Thread(new UpdateDisplayThread()).start();

    }   // end onCreate()


        ////////////////////////////////////////////////////////////////////////
        /////////////////////// PRIVATE MEMBER FUNCTIONS ///////////////////////
        ////////////////////////////////////////////////////////////////////////
        /**
         * Starts the timer if its not already running.
         */
        private void startTimer()
        {
            Toast.makeText(this, "Starting Timer", Toast.LENGTH_LONG).show();

            if(getTimerState())
            {
                // timer is running, don't do anything
            }
            else
            {
                // timer is not running, start it
                long time_stamp = (new Date()).getTime();
                setTimerStart(time_stamp);
                setTimerState(true);
            }
        }


        /**
         * Stops the timer if its running
         */
        private void stopTimer ()
        {
            Toast.makeText(this, "Stopping Timer", Toast.LENGTH_LONG).show();

            if(getTimerState())
            {
                // timer is running, stop the timer
                long time_stamp = (new Date()).getTime();
                setTimerStop(time_stamp);
                setTimerState(false);
            }
            else
            {
                // timer is not running don't do anything
            }

        }


    /**
     * Get current state of timer: running or not.
     * @return true if the timer is running, false otherwise
     */
    private boolean getTimerState()
    {
        Context           app_context = getApplicationContext();
        SharedPreferences shared_pref = getDefaultSharedPreferences(app_context);
        return shared_pref.getBoolean(PATROL_TIMER_STATE, false);
    }


    /**
     * Sets current state of timer: running or not.  This value is written to
     * persistence storage.
     * @param timerState true if the timer is running, false otherwise
     */
    private void setTimerState(boolean timerState)
    {
        Context           app_context = getApplicationContext();
        SharedPreferences shared_pref = getDefaultSharedPreferences(app_context);
        SharedPreferences.Editor pref_editor = shared_pref.edit();
        pref_editor.putBoolean(PATROL_TIMER_STATE, timerState);
        pref_editor.commit();
    }


    /**
     * Get the timer start timestamp from persistence.  This value is the
     * number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return timer start time
     */
    private long getTimerStart()
    {
        Context           app_context = getApplicationContext();
        SharedPreferences shared_pref = getDefaultSharedPreferences(app_context);
        return shared_pref.getLong(PATROL_TIMER_START, 0);
    }


    /**
     * Set the timer start timestamp in persistence.  This value should be the
     * number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return timer start time
     */
    private void setTimerStart(long timerStart)
    {
        Context           app_context = getApplicationContext();
        SharedPreferences shared_pref = getDefaultSharedPreferences(app_context);
        SharedPreferences.Editor pref_editor = shared_pref.edit();
        pref_editor.putLong(PATROL_TIMER_START, timerStart);
        pref_editor.commit();
    }


    /**
     * Get the timer stop timestamp from persistence.  This value is the
     * number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return timer start time
     */
    private long getTimerStop()
    {
        Context           app_context = getApplicationContext();
        SharedPreferences shared_pref = getDefaultSharedPreferences(app_context);
        return shared_pref.getLong(PATROL_TIMER_STOP, 0);
    }


    /**
     * Set the timer stop timestamp in persistence.  This value should be the
     * number of milliseconds since January 1, 1970, 00:00:00 GMT
     * @return timer start time
     */
    private void setTimerStop(long timerStop)
    {
        Context           app_context = getApplicationContext();
        SharedPreferences shared_pref = getDefaultSharedPreferences(app_context);
        SharedPreferences.Editor pref_editor = shared_pref.edit();
        pref_editor.putLong(PATROL_TIMER_START, timerStop);
        pref_editor.commit();
    }


    /**
     * Update the timer display
     */
    private void updateTimerDisplay()
    {
        if(getTimerState())
        {
            // here the timer is running
            Long timer_start = getTimerStart();
            Long timer_curr  = (new Date()).getTime();
            Long elap_secs   = (timer_curr - timer_start) / 1000;
            mEditTextElapsed.setText(elap_secs.toString());
        }
        else
        {
            // here the timer is not running
            Long timer_start = getTimerStart();
            Long timer_curr  = getTimerStop();
            Long elap_secs   = (timer_curr - timer_start) / 1000;
            mEditTextElapsed.setText(elap_secs.toString());
        }
    }


    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////// INTERNAL CLASSES /////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Class UpdateDisplay.  Updates the elapsed time display in a background
     * thread.
     */
    class UpdateDisplayThread implements Runnable
    {
        public boolean update_loop;

        @Override
        public void run()
        {
            update_loop = true;

            while(update_loop)
            {
                updateTimerDisplay();

                try
                {
                    Thread.sleep(500);
                }
                catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }

        }
    }   // end class UpdateDisplayThread implements Runnable

}   // end public class TimerActivity extends AppCompatActivity
