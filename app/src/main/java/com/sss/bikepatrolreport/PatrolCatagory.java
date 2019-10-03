package com.sss.bikepatrolreport;

public class PatrolCatagory
{
    String   mPatrolCatagory;
    String   mPatrolLocation;
    String[] mMtnBikeTrails;

    /**
     * Constructor
     */
    public PatrolCatagory(String patrolCatagory, String patrolLocation, String[] mtnBikeTrails)
    {
        mPatrolCatagory = patrolCatagory;
        mPatrolLocation = patrolLocation;
        mMtnBikeTrails  = mtnBikeTrails;
    }
}   // end public class PatrolCatagory
