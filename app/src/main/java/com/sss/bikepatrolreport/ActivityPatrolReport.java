package com.sss.bikepatrolreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.widget.Toast;

import static com.sss.bikepatrolreport.UtilSharedPreferences.*;

/**
 * Class ActivityPatrolReport
 */
public class ActivityPatrolReport extends AppCompatActivity
{
    private final static String TAG = "ActivityPatrolReport";

    private UtilSharedPreferences mSharedPref;
    private String                mActivityReport;

    /**
     * Implementation of Android life cycle onCreate function
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patrol_report);
        mSharedPref = new UtilSharedPreferences(getApplicationContext());

        buildActivityReport();
        emailActivityReport();
    }


    /**
     * Build the activity report
     */
    private void buildActivityReport()
    {
        mActivityReport =
            "UserFullName:" + mSharedPref.getString(USER_FULL_NAME, DEF_USER_FULL_NAME) + "\n" +
            "UserID:"       + mSharedPref.getString(USER_ID,        DEF_USER_ID)        + "\n" +
            "Password:"     + mSharedPref.getString(USER_PASSWORD,  DEF_USER_PASSWORD)  + "\n" +
            "EMail:"        + mSharedPref.getString(EMAIL_TO,       DEF_EMAIL_TO)       + "\n" +
            "EMailAddr:"    + mSharedPref.getString(EMAIL_ADDRESS,  DEF_EMAIL_ADDRESS)  + "\n" +
            "EMailSubject:" + mSharedPref.getString(EMAIL_SUBJECT,  DEF_EMAIL_SUBJECT);

        Log.i(TAG, "buildActivityReport() = " + mActivityReport);
    }


    /**
     * Email the activity report
     */
    private void emailActivityReport()
    {
        String email_addr = mSharedPref.getString(EMAIL_ADDRESS,  DEF_EMAIL_ADDRESS);
        String email_sub  = mSharedPref.getString(EMAIL_SUBJECT,  DEF_EMAIL_SUBJECT);


        //Intent intent = new Intent(Intent.ACTION_SENDTO);
        //intent.setType("text/plain");
        //intent.putExtra(Intent.EXTRA_EMAIL,   email_addr);
        //intent.putExtra(Intent.EXTRA_SUBJECT, email_sub);
        //intent.putExtra(Intent.EXTRA_TEXT,    mActivityReport);

        //startActivity(Intent.createChooser(intent, "Send Email"));

        // send the email
        Intent send_email = new Intent(Intent.ACTION_SENDTO);
        send_email.setType(("message/rfc822"));
        send_email.putExtra(Intent.EXTRA_EMAIL,   new String[]{email_addr});
        send_email.putExtra(Intent.EXTRA_SUBJECT, email_sub);
        send_email.putExtra(Intent.EXTRA_TEXT,    mActivityReport);

        try
        {
            startActivity(Intent.createChooser(send_email,
                    "Send Bike Patrol Report Email"));
        }
        catch(android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(this, "WARNING: there are no email clients installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}   // end public class ActivityPatrolReport extends AppCompatActivity
