package com.sss.bikepatrolreport;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class PatrolLocationActivity extends AppCompatActivity
{
    private final static String TAG = "PatrolLocationActivity";
    // patrol catagories

    private PatrolCatagory mPatrolCatagoryCity;
    private PatrolCatagory mPatrolCatagoryCounty;
    private PatrolCatagory mPatrolCatagoryUSFS;
    private PatrolCatagory mPatrolCatagoryValmont;


    /**
     * Android lifecycle function onCreate()
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patrol_location);

        // configure the action bar and handle its messages
        ActionBar action_bar = getSupportActionBar();
        action_bar.setTitle(R.string.action_bar_title);

        initializePatrolTrailData();
    }


    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////// PRIVATE MEMBER FUNCTIONS /////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Initialize Patrol Trail data
     */
    private void initializePatrolTrailData()
    {
        // City Patrol

        // County Patrol
        PatrolTrails trails_hall_ranch = new PatrolTrails("Hall Ranch");
        trails_hall_ranch.addTrail("Antelope");
        trails_hall_ranch.addTrail("Bitterbrush");
        trails_hall_ranch.addTrail("Nelson");
        Log.i(TAG, trails_hall_ranch.toString());

        PatrolTrails trails_heil_ranch = new PatrolTrails("Heil Ranch");
        trails_heil_ranch.addTrail("Overland");
        trails_heil_ranch.addTrail("Picture Rock");
        trails_heil_ranch.addTrail("Ponderosa Loop");
        trails_heil_ranch.addTrail("Schoolhouse");
        trails_heil_ranch.addTrail("Wapiti");
        trails_heil_ranch.addTrail("Wild Turkey");
        Log.i(TAG, trails_heil_ranch.toString());

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
        Log.i(TAG, trails_misc.toString());

        PatrolTrails trails_rabbit_valley = new PatrolTrails("Rabbit Valley");
        trails_rabbit_valley.addTrail("Eagle Wind Trail");
        trails_rabbit_valley.addTrail("Indian Mesa");
        trails_rabbit_valley.addTrail("Little Thompson");
        Log.i(TAG, trails_rabbit_valley.toString());

        PatrolTrails trails_walker_ranch = new PatrolTrails("Walker Ranch");
        trails_walker_ranch.addTrail("Meyers Homestead");
        trails_walker_ranch.addTrail("Walker Loop");
        Log.i(TAG, trails_walker_ranch.toString());

        // USFS Patrol

        // Valmont Bike Park Patrol


    }

}   // end public class PatrolLocationActivity extends AppCompatActivity
