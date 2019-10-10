package com.sss.bikepatrolreport;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Class TrailSelectionActivity: allows the user to select the trails
 * patrolled from a list associated with the specified patrol type.
 */
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

    private PatrolType mPatrolType;     // patrol type trail list

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_selection);

        int patrol_type_id = getExtras();
        String patrol_type_str = setPatrolType(patrol_type_id);

        // display the patrol type in the action bar
        ActionBar action_bar = getSupportActionBar();
        action_bar.setTitle(patrol_type_str);

        // display the trails in check boxes
        LinearLayout linear_layout = findViewById(R.id.ll_trail_selection);
        ArrayList<PatrolTrails> patrol_trails = mPatrolType.getPatrolTrailSystem();
        for(PatrolTrails patrol_trail_sys : patrol_trails)
        {
            String            trail_area_name = patrol_trail_sys.getTrailAreaName();
            ArrayList<String> trail_list      = patrol_trail_sys.getTrailList();

            TextView tv_trail_area = new TextView(this);
            tv_trail_area.setText(trail_area_name);
            linear_layout.addView(tv_trail_area);

            for(String trail_name : trail_list)
            {
                CheckBox check_box = new CheckBox(this);
                check_box.setText(trail_name);
                linear_layout.addView(check_box);
            }
        }

    }   // end protected void onCreate(Bundle savedInstanceState)

    /**
     * Get extras from intent that started this activity
     *
     * @return patrol type identifier
     */
    private int getExtras()
    {
        Intent this_intent = getIntent();
        int patrol_type_id = this_intent.getIntExtra(EXTRA_PATROL_TYPE, 0);
        Log.i(TAG, "getExtras(): patrol type id= " + patrol_type_id);
        return patrol_type_id;
    }


    /**
     * Set the patrol type
     *
     * @param patrolTypeId identifies patrol type
     *
     * @return string description of the patrol type
     */
    private String setPatrolType(int patrolTypeId)
    {
        String patrol_type_str = lookupPatrolType(patrolTypeId);

        // initialize patrol trail list
        switch(patrolTypeId)
        {
            case PATROL_TYPE_CITY:
                initCityPatrolTrailList(patrol_type_str);
                break;
            case PATROL_TYPE_COUNTY:
                initCountyPatrolTrailList(patrol_type_str);
                break;
            case PATROL_TYPE_USFS:
                initUSFSPatrolTrailList(patrol_type_str);
                break;
            case PATROL_TYPE_VALMONT:
                initValmontPatrolTrailList(patrol_type_str);
                break;
            case PATROL_TYPE_UNKNOWN:
            default:
                break;
        }

        return patrol_type_str;
    }


    /**
     * Lookup ASCII description of patrol type for display
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


    /**
     * Initialize City Patrol Trail List
     */
    private void initCityPatrolTrailList(String patrolType)
    {

    }


    /**
     * Initialize County Patrol Trail List
     *
     * @param patrolType string description of patrol type
     */
    private void initCountyPatrolTrailList(String patrolType)
    {
        Log.i(TAG, "initCountyPatrolTrailList(): patrol type = " + patrolType);

        PatrolTrails trails_hall_ranch = new PatrolTrails("Hall Ranch");
        trails_hall_ranch.addTrail("Antelope");
        trails_hall_ranch.addTrail("Bitterbrush");
        trails_hall_ranch.addTrail("Nelson");
        //Log.i(TAG, trails_hall_ranch.toString());

        PatrolTrails trails_heil_ranch = new PatrolTrails("Heil Ranch");
        trails_heil_ranch.addTrail("Overland");
        trails_heil_ranch.addTrail("Picture Rock");
        trails_heil_ranch.addTrail("Ponderosa Loop");
        trails_heil_ranch.addTrail("Schoolhouse");
        trails_heil_ranch.addTrail("Wapiti");
        trails_heil_ranch.addTrail("Wild Turkey");
        //Log.i(TAG, trails_heil_ranch.toString());

        PatrolTrails trails_misc = new PatrolTrails("Misc");
        trails_misc.addTrail("Betasso Preserve");
        trails_misc.addTrail("Boulder Canyon");
        trails_misc.addTrail("Coal Creek Trail");
        trails_misc.addTrail("Logerman Agriculture Preserve");
        trails_misc.addTrail("Lobo");
        trails_misc.addTrail("Mud Lake (Nederland)");
        trails_misc.addTrail("Niwot Loop Trail");
        trails_misc.addTrail("Pella");
        trails_misc.addTrail("Pines to Peak");
        trails_misc.addTrail("Rock Creek");
        trails_misc.addTrail("Sherwood Gulch");
        //Log.i(TAG, trails_misc.toString());

        PatrolTrails trails_rabbit_valley = new PatrolTrails("Rabbit Valley");
        trails_rabbit_valley.addTrail("Eagle Wind Trail");
        trails_rabbit_valley.addTrail("Indian Mesa");
        trails_rabbit_valley.addTrail("Little Thompson");
        //Log.i(TAG, trails_rabbit_valley.toString());

        PatrolTrails trails_walker_ranch = new PatrolTrails("Walker Ranch");
        trails_walker_ranch.addTrail("Meyers Homestead");
        trails_walker_ranch.addTrail("Walker Loop");
        //Log.i(TAG, trails_walker_ranch.toString());

        mPatrolType = new PatrolType(patrolType);
        mPatrolType.addPatrolTrails(trails_hall_ranch);
        mPatrolType.addPatrolTrails(trails_heil_ranch);
        mPatrolType.addPatrolTrails(trails_misc);
        mPatrolType.addPatrolTrails(trails_rabbit_valley);
        mPatrolType.addPatrolTrails(trails_walker_ranch);
        Log.i(TAG, mPatrolType.toString());
    }   // end private void initCountyPatrolTrailList()


    /**
     * Initialize USFS Patrol Trail List
     */
    private void initUSFSPatrolTrailList(String patrolType)
    {

    }


    /**
     * Initialize Valmont Patrol Trail List
     */
    private void initValmontPatrolTrailList(String patrolType)
    {

    }

}   // end public class TrailSelectionActivity extends AppCompatActivity
