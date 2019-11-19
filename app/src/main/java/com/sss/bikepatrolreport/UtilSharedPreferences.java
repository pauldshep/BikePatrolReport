package com.sss.bikepatrolreport;


import android.content.Context;
import android.content.SharedPreferences;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Class UtilSharedPreferences.  Encapsulates all Default Shared Preferences
 * functions
 */
public class UtilSharedPreferences
{
    // timer parameters
    public final static String PATROL_TIMER_STATE = "patrol_timer_state";
    public final static String PATROL_TIMER_START = "patrol_timer_start";
    public final static String PATROL_TIMER_STOP  = "patrol_timer_stop";

    // counter preferences
    public final static String SEEN_NUM_HIKERS         = "seen_num_hikers";
    public final static String SEEN_NUM_EQUESTRIANS    = "seen_num_equestrians";
    public final static String SEEN_NUM_BIKERS         = "seen_num_bikers";
    public final static String SEEN_NUM_EBIKERS        = "seen_num_ebikers";
    public final static String SEEN_NUM_ANGLERS        = "seen_num_anglers";
    public final static String SEEN_NUM_RUNNERS        = "seen_num_runners";
    public final static String SEEN_NUM_DOGS_UNLEASHED = "seen_num_dogs_unleashed";
    public final static String SEEN_NUM_DOGS_LEASHED   = "seen_num_dogs_leashed";

    public final static String SERVICES_EDUCATION      = "services_education";
    public final static String SERVICES_DIRECTIONS     = "services_directions";
    public final static String SERVICES_MECHANICAL     = "services_mechanical";
    public final static String SERVICES_FIRST_AID      = "services_first_aid";
    public final static String SERVICES_TRAIL_WORK     = "services_trail_work";

    // general app configuration
    public final static String USER_FULL_NAME          = "user_full_name";
    public final static String USER_ID                 = "user_id";
    public final static String USER_PASSWORD           = "user_password";
    public final static String EMAIL_TO                = "email_to";
    public final static String EMAIL_ADDRESS           = "email_address";
    public final static String EMAIL_SUBJECT           = "email_subject";

    public final static String DEF_USER_FULL_NAME      = "User Name";
    public final static String DEF_USER_ID             = "userid";
    public final static String DEF_USER_PASSWORD       = "password";
    public final static String DEF_EMAIL_TO            = "email to name";
    public final static String DEF_EMAIL_ADDRESS       = "email@address.com";
    public final static String DEF_EMAIL_SUBJECT       = "Bike Patrol Report";

    private SharedPreferences        mSharedPreferences;
    private SharedPreferences.Editor mSharedPrefEditor;


    /**
     * Constructor
     * @param appContext android application context
     */
    public UtilSharedPreferences(Context appContext)
    {
        mSharedPreferences = getDefaultSharedPreferences(appContext);
        mSharedPrefEditor  = mSharedPreferences.edit();
    }


    /**
     * Lookup and return boolean shared preference
     * @param prefIdent preference identification string
     * @param defaultValue default preference value to return
     * @return specified boolean shared preference value
     */
    public boolean getBoolean(String prefIdent, boolean defaultValue)
    {
        return mSharedPreferences.getBoolean(prefIdent, defaultValue);
    }


    /**
     * Set boolean shared preference value
     */
    public void putBoolean(String prefIdent, boolean prefValue)
    {
        mSharedPrefEditor.putBoolean(prefIdent, prefValue).apply();
    }


    /**
     * Lookup and return Long shared preference
     */
    public long getLong(String prefIdent, long defaultValue)
    {
        return mSharedPreferences.getLong(prefIdent, defaultValue);
    }


    /**
     * Set Long shared preference value
     * @param prefIdent shared preference identifier
     * @param prefValue shared preference String value
     */
    public void putLong(String prefIdent, long prefValue)
    {
        mSharedPrefEditor.putLong(prefIdent, prefValue).apply();
    }


    /**
     * Lookup and return String shared preference
     * @param prefIdent preference identification string
     * @param defaultValue default preference value to return
     * @return specified String shared preference value
     */
    public String getString(String prefIdent, String defaultValue)
    {
        return mSharedPreferences.getString(prefIdent, defaultValue);
    }


    /**
     * Set String shared preference value
     * @param prefIdent shared preference identifier
     * @param prefValue shared preference String value
     */
    public void putString(String prefIdent, String prefValue)
    {
        mSharedPrefEditor.putString(prefIdent, prefValue).apply();
    }
}   // end public class UtilSharedPreferences
