package com.sss.bikepatrolreport;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.sss.bikepatrolreport.TrailSelectionActivity.*;

public class PatrolLocationActivity extends AppCompatActivity
{
    private final static String TAG = "PatrolLocationActivity";
    // patrol categories

    private PatrolCategory mPatrolCategoryCity;
    private PatrolCategory mPatrolCategoryCounty;
    private PatrolCategory mPatrolCategoryUSFS;
    private PatrolCategory mPatrolCategoryValmont;


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
        action_bar.setTitle(R.string.action_bar_patrol_location);

        initializePatrolTrailData();

        Button btn_city_patrol  = findViewById(R.id.btn_city_patrol);
        btn_city_patrol.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                handleCityPatrol();
            }
        });


        Button btn_county_patrol  = findViewById(R.id.btn_county_patrol);
        btn_county_patrol.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                handleCountyPatrol();
            }
        });


        Button btn_usfs_patrol  = findViewById(R.id.btn_usfs_patrol);
        btn_usfs_patrol.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                handleUSFSPatrol();
            }
        });


        Button btn_valmont_patrol  = findViewById(R.id.btn_valmont_patrol);
        btn_valmont_patrol.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                handleValmontPatrol();
            }
        });
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

    }   // end private void initializePatrolTrailData()


    /**
     * Handle user selection of City Patrol Button
     */
    private void handleCityPatrol()
    {
        Toast.makeText(this, "City Patrol Selected",
                        Toast.LENGTH_SHORT).show();
        TrailSelectionActivity(PATROL_TYPE_CITY);
    }


    /**
     * Handle user selection of County Patrol Button
     */
    private void handleCountyPatrol()
    {
        Toast.makeText(this, "County Patrol Selected",
                Toast.LENGTH_SHORT).show();
        TrailSelectionActivity(PATROL_TYPE_COUNTY);
    }


    /**
     * Handle user selection of USFS Patrol Button
     */
    private void handleUSFSPatrol()
    {
        Toast.makeText(this, "USFS Patrol Selected",
                Toast.LENGTH_SHORT).show();
        TrailSelectionActivity(PATROL_TYPE_USFS);
    }


    /**
     * Handle user selection of Valmont Bike Park Patrol Button
     */
    private void handleValmontPatrol()
    {
        Toast.makeText(this, "Valmont Patrol Selected",
                Toast.LENGTH_SHORT).show();
        TrailSelectionActivity(PATROL_TYPE_VALMONT);
    }


    /**
     * Transition to the trail system display activity
     */
    private void TrailSelectionActivity(int patrolType)
    {
        Intent intent = new Intent(this, TrailSelectionActivity.class);
        intent.putExtra(EXTRA_PATROL_TYPE, patrolType);
        startActivity(intent);
    }

}   // end public class PatrolLocationActivity extends AppCompatActivity
