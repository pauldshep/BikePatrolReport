package com.sss.bikepatrolreport;


import java.util.ArrayList;


/**
 * Encapsulates groups of trails that are close to each other
 */
public class PatrolTrails
{
    private String                 mTrailArea;
    private ArrayList<PatrolTrail> mTrails;

    /**
     * Constructor
     */
    public PatrolTrails(String trailArea)
    {
        mTrailArea = trailArea;
        mTrails    = new ArrayList<PatrolTrail>();
    }


    /**
     * Adds a trail to the internal list
     */
    public void addTrail(PatrolTrail patrolTrail)
    {
        mTrails.add(patrolTrail);
    }


    /**
     * Get the name of the trail area
     *
     * @return trail area name
     */
    public String getTrailAreaName()
    {
        return mTrailArea;
    }


    /**
     * Get the list of trails in this trail system
     *
     * @return list of trails in the trail system
     */
    public ArrayList<PatrolTrail> getTrailList()
    {
        return mTrails;
    }


    /**
     * Implement the toString() method
     */
    @Override
    public String toString()
    {
        StringBuilder patrol_trails = new StringBuilder();
        patrol_trails.append("Trail Area: " + mTrailArea + "\n");

        for(PatrolTrail patrol_trail : mTrails)
        {
            patrol_trails.append("  " + patrol_trail.toString() + "\n");
        }

        return patrol_trails.toString();
    }
}   // end public class PatrolTrails
