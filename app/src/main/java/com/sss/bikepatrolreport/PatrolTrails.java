package com.sss.bikepatrolreport;


import java.util.Vector;


/**
 * Encapsulates groups of trails that are close to each other
 */
public class PatrolTrails
{
    private String         mTrailArea;
    private Vector<String> mTrails;

    /**
     * Constructor
     */
    public PatrolTrails(String trailArea)
    {
        mTrailArea = trailArea;
        mTrails    = new Vector<String>();
    }


    /**
     * Adds a trail to the internal list
     */
    public void addTrail(String patrolTrail)
    {
        mTrails.add(patrolTrail);
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
