package com.sss.bikepatrolreport;

public class PatrolCategory
{
    String   mPatrolCatagory;
    String   mPatrolLocation;
    String[] mMtnBikeTrails;

    /**
     * Constructor
     */
    public PatrolCategory(String patrolCatagory, String patrolLocation, String[] mtnBikeTrails)
    {
        mPatrolCatagory = patrolCatagory;
        mPatrolLocation = patrolLocation;
        mMtnBikeTrails  = mtnBikeTrails;
    }
}   // end public class Patrol Category
