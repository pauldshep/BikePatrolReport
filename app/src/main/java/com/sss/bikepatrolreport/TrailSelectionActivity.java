package com.sss.bikepatrolreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TrailSelectionActivity extends AppCompatActivity
{
    private final static String TAG = "TrailSelectionActivity";

    // flag for the patrol types listed below
    public final static String EXTRA_PATROL_TYPE = "extra_patrol_type";

    // patrol types sent to this activity as extra's
    public final static int PATROL_TYPE_UNKNOWN = 0;
    public final static int PATROL_TYPE_CITY    = 1;
    public final static int PATROL_TYPE_COUNTY  = 2;
    public final static int PATROL_TYPE_USFS    = 3;
    public final static int PATROL_TYPE_VALMONT = 4;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_selection);

        getExtras();
    }   // end protected void onCreate(Bundle savedInstanceState)

    /**
     * Get extras from intent that started this activity
     */
    private void getExtras()
    {
        Intent this_intent = getIntent();
        int patrol_type = this_intent.getIntExtra(EXTRA_PATROL_TYPE, 0);
        Log.i(TAG, "getExtras(): patrol type = " + patrol_type);

        setPatrolType(patrol_type);
    }


    /**
     * Set the patrol type
     */
    private void setPatrolType(int patrolType)
    {
        String patrol_type = lookupPatrolType(patrolType);

        TextView tv_patrol_area = findViewById(R.id.tv_patrol_area);
        tv_patrol_area.setText(patrol_type);
    }


    /**
     * Lookup ASCII equivalent of patrol type for display
     */
    private String lookupPatrolType(Integer patrolType)
    {
        switch(patrolType)
        {
            case PATROL_TYPE_CITY:      return "City Patrol";
            case PATROL_TYPE_COUNTY:    return "County Patrol";
            case PATROL_TYPE_USFS:      return "USFS Patrol";
            case PATROL_TYPE_VALMONT:   return "Valmont Patrol";
            case PATROL_TYPE_UNKNOWN:
            default:                    return "Unknown Patrol";
        }
    }   // end private String lookupPatrolType(Integer patrolType)

}   // end public class TrailSelectionActivity extends AppCompatActivity
