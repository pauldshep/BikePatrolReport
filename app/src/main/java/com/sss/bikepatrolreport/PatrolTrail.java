package com.sss.bikepatrolreport;

import android.support.annotation.NonNull;
import android.widget.CheckBox;

/**
 * Class PatrolTrail:
 * Encapsulates a single mountain bike trail that can be patrolled.
 */
public class PatrolTrail
{
    private String   mPatrolTrail = "Unknown Trail";
    private CheckBox mCheckBox    = null;

    /**
     * Constructor
     *
     * @param patrolTrail name of the trail that can be patrolled
     */
    public PatrolTrail(String patrolTrail)
    {
        mPatrolTrail = patrolTrail;
    }

    /**
     * Get the patrol trail name
     *
     * @return patrol trail name
     */
    public String getTrailName()
    {
        return mPatrolTrail;
    }


    /**
     * Sets the check box reference associated with this trail
     */
    public void setCheckBoxReference(CheckBox checkBox)
    {
        mCheckBox = checkBox;
    }


    /**
     * Get the check box state: checked(true) or unchecked(false)
     *
     * return true if the checkbox is checked, false otherwise
     */
    public boolean getCheckBoxState()
    {
        if(mCheckBox == null)
            return false;

        return mCheckBox.isChecked();
    }


    /**
     * Set the check box state to true(checked) or false(not checked)
     *
     * @param isChecked if true set check box state to checked, not
     *                  checked otherwise
     */
    public void setCheckBoxState(boolean isChecked)
    {
        mCheckBox.setChecked(isChecked);
    }


    /**
     * Implement the toString() method for this class
     */
    @Override
    @NonNull
    public String toString()
    {
        return mPatrolTrail;
    }
}   // end public class PatrolTrail
