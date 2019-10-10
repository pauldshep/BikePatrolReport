package com.sss.bikepatrolreport;

import java.util.ArrayList;

/**
 * Class PatrolType:  Encapsulates the type of patrol: City, County, USFS, or
 * Valmont Bike Park.  Name of the Patrol Type and associated trails are
 * saved here.
 */
public class PatrolType
{
    private String                  mPatrolType        = "Unknown";
    private ArrayList<PatrolTrails> mPatrolTrailSystem = new ArrayList<PatrolTrails>();

    /**
     * Constructor
     */
    public PatrolType(String patrolType)
    {
        mPatrolType = patrolType;
    }


    /**
     * Adds a trail system to an internal list associated with the patrol type
     *
     * @param patrolTrails trail system associated with patrol type
     */
    public void addPatrolTrails(PatrolTrails patrolTrails)
    {
        mPatrolTrailSystem.add(patrolTrails);
    }


    /**
     * Get the internal list of patrol trail systems
     *
     * @return internal list of the patrol trail system
     */
    public ArrayList<PatrolTrails> getPatrolTrailSystem()
    {
        return mPatrolTrailSystem;
    }

    /**
     * Implement the Java toString() function for this class
     *
     * @return class string description
     */
    @Override
    public String toString()
    {
        StringBuilder str_bld = new StringBuilder("Patrol Type: " + mPatrolType + "\n");

        for(PatrolTrails patrolTrails : mPatrolTrailSystem)
        {
            str_bld.append(patrolTrails.toString());
        }

        return str_bld.toString();
    }
}   // end public class Patrol Category
