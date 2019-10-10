package com.sss.bikepatrolreport;


import java.util.ArrayList;


/**
 * Encapsulates groups of trails that are close to each other
 */
public class PatrolTrails
{
    private String            mTrailArea;
    private ArrayList<String> mTrails;

    /**
     * Constructor
     */
    public PatrolTrails(String trailArea)
    {
        mTrailArea = trailArea;
        mTrails    = new ArrayList<String>();
    }


    /**
     * Adds a trail to the internal list
     */
    public void addTrail(String patrolTrail)
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
    public ArrayList<String> getTrailList()
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

        for(String trail : mTrails)
        {
            patrol_trails.append("  " + trail + "\n");
        }

        return patrol_trails.toString();
    }
}   // end public class PatrolTrails
