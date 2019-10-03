package com.sss.bikepatrolreport;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private final static String TAG = "MainActivity";

    private EditText mNumHikers;
    private EditText mNumEquestrians;
    private EditText mNumBikers;
    private EditText mNumEBikers;
    private EditText mNumAnglers;
    private EditText mNumRunners;
    private EditText mNumDogsUnleashed;
    private EditText mNumDogsLeashed;
    private EditText mNumEducationContacts;
    private EditText mNumDirectionsMap;
    private EditText mNumMechanical;
    private EditText mNumFirstAid;
    private EditText mNumTrailWork;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // configure the action bar and handle its messages
        ActionBar action_bar = getSupportActionBar();
        action_bar.setTitle(R.string.action_bar_title);

        // number hikers
        mNumHikers          = findViewById(R.id.et_num_hikers);
        Button inc_hikers = findViewById(R.id.btn_inc_hikers);
        inc_hikers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumHikers, 1);
            }
        });

        Button dec_hikers = findViewById(R.id.btn_dec_hikers);
        dec_hikers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumHikers, -1);
            }
        });

        // number equestrians
        mNumEquestrians     = findViewById(R.id.et_num_eques);
        Button inc_equest = findViewById(R.id.btn_inc_equestrians);
        inc_equest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumEquestrians, 1);
            }
        });

        Button dec_equest = findViewById(R.id.btn_dec_equestrians);
        dec_equest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumEquestrians, -1);
            }
        });

        // number bikers
        mNumBikers        = findViewById(R.id.et_num_bikers);
        Button inc_bikers = findViewById(R.id.btn_inc_bikers);
        inc_bikers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumBikers, 1);
            }
        });

        Button dec_bikers = findViewById(R.id.btn_dec_bikers);
        dec_bikers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumBikers, -1);
            }
        });

        // number ebikers
        mNumEBikers        = findViewById(R.id.et_num_ebikers);
        Button inc_ebikers = findViewById(R.id.btn_inc_ebikers);
        inc_ebikers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumEBikers, 1);
            }
        });

        Button dec_ebikers = findViewById(R.id.btn_dec_ebikers);
        dec_ebikers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumEBikers, -1);
            }
        });

        // number anglers
        mNumAnglers        = findViewById(R.id.et_num_anglers);
        Button inc_anglers = findViewById(R.id.btn_inc_anglers);
        inc_anglers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumAnglers, 1);
            }
        });

        Button dec_anglers = findViewById(R.id.btn_dec_anglers);
        dec_anglers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumAnglers, -1);
            }
        });

        // number runners
        mNumRunners        = findViewById(R.id.et_num_runners);
        Button inc_runners = findViewById(R.id.btn_inc_runners);
        inc_runners.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumRunners, 1);
            }
        });

        Button dec_runners = findViewById(R.id.btn_dec_runners);
        dec_runners.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumRunners, -1);
            }
        });

        // number dogs unleashed
        mNumDogsUnleashed         = findViewById(R.id.et_num_dogs_unleashed);
        Button inc_dogs_unleashed = findViewById(R.id.btn_inc_dogs_unleashed);
        inc_dogs_unleashed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumDogsUnleashed, 1);
            }
        });

        Button dec_dogs_unleashed = findViewById(R.id.btn_dec_dogs_unleashed);
        dec_dogs_unleashed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumDogsUnleashed, -1);
            }
        });

        // number dogs leashed
        mNumDogsLeashed         = findViewById(R.id.et_num_dogs_leashed);
        Button inc_dogs_leashed = findViewById(R.id.btn_inc_dogs_leashed);
        inc_dogs_leashed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumDogsLeashed, 1);
            }
        });

        Button dec_dogs_leashed = findViewById(R.id.btn_dec_dogs_leashed);
        dec_dogs_leashed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumDogsLeashed, -1);
            }
        });


        // Education/contacts
        mNumEducationContacts   = findViewById(R.id.et_num_education_contacts);
        Button inc_edu_contacts = findViewById(R.id.btn_inc_education_contacts);
        inc_edu_contacts.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumEducationContacts, 1);
            }
        });

        Button dec_edu_contacts = findViewById(R.id.btn_dec_education_contacts);
        dec_edu_contacts.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumEducationContacts, -1);
            }
        });

        // Directions/Map
        mNumDirectionsMap   = findViewById(R.id.et_num_directions_map);
        Button inc_dir_map  = findViewById(R.id.btn_inc_directions_map);
        inc_dir_map.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumDirectionsMap, 1);
            }
        });

        Button dec_dir_map = findViewById(R.id.btn_dec_directions_map);
        dec_dir_map.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumDirectionsMap, -1);
            }
        });

        // Mechanical
        mNumMechanical        = findViewById(R.id.et_num_mechanical);
        Button inc_mechanical = findViewById(R.id.btn_inc_mechanical);
        inc_mechanical.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumMechanical, 1);
            }
        });

        Button dec_mechanical = findViewById(R.id.btn_dec_mechanical);
        dec_mechanical.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumMechanical, -1);
            }
        });

        // First aid
        mNumFirstAid        = findViewById(R.id.et_first_aid);
        Button inc_first_aid = findViewById(R.id.btn_inc_first_aid);
        inc_first_aid.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumFirstAid, 1);
            }
        });

        Button dec_first_aid = findViewById(R.id.btn_dec_first_aid);
        dec_first_aid.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumFirstAid, -1);
            }
        });

        // Trail work
        mNumTrailWork         = findViewById(R.id.et_trail_work);
        Button inc_trail_work = findViewById(R.id.btn_inc_trail_work);
        inc_trail_work.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumTrailWork, 1);
            }
        });

        Button dec_trail_work = findViewById(R.id.btn_dec_trail_work);
        dec_trail_work.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                incDecEditText(mNumTrailWork, -1);
            }
        });

        Button submit_report = findViewById((R.id.btn_submit_report));
        submit_report.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SubmitActivityReport();
            }

        });

    }   // end onCreate()


    /**
     * Create toolbar options menu
     */
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_actionbar_menu, menu);
        return true;
    }


    /**
     * Handle action bar menu item selection
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_bar_trails:
                TrailSelectionActivity();
                break;

            case R.id.action_bar_about:
                Toast.makeText(this, "About Selected",
                        Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "Unsupported Menu Selection",
                        Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }


    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////// PRIVATE MEMBER FUNCTIONS /////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     *
     */


    /**
     * Increments or decrements the numeric value in an EditText and updates
     * the EditText display.
     *
     * @param editText
     * @param inc_dec
     */
    private void incDecEditText(EditText editText, int inc_dec)
    {
        int int_val;

        try
        {
            int_val = Integer.parseInt(editText.getText().toString());
            int_val += inc_dec;

            if(int_val < 0)
            {
                int_val = 0;
            }
        }
        catch(NumberFormatException nfe)
        {
            int_val = 0;
        }

        editText.setText(Integer.toString(int_val));
    }   // end private void incDecEditText(EditText editText, int inc_dec)


    /**
     * Submits an activity report after checking for problems
     */
    private void SubmitActivityReport()
    {
        Toast.makeText(this,
                "Activity Report Submitted",
                Toast.LENGTH_LONG).show();
    }


    /**
     * Transition to the trail selection activity
     */
    private void TrailSelectionActivity()
    {
        //Toast.makeText(this, "Trail Selection Activity",
        //        Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, PatrolLocationActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}   // end public class MainActivity extends AppCompatActivity
