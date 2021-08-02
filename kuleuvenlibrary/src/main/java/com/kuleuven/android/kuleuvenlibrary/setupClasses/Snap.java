package com.kuleuven.android.kuleuvenlibrary.setupClasses;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Snap
 *
 * Class to define a snapping locations the DragAndDropActivities
 */
public class Snap extends LinearLayout {

    private Float locationX;
    private Float locationY;
    private Float defaultRotation;

    public Snap(Context context) {
        super(context);
    }

    public Snap(Context context, Float locationX, Float locationY, Float defaultRotation) {
        super(context);
        this.locationX = locationX;
        this.locationY = locationY;
        this.defaultRotation = defaultRotation;
    }

    public Float getLocationX() {
        return locationX;
    }

    public Float getLocationY() {
        return locationY;
    }

    public Float getDefaultRotation() {
        return defaultRotation;
    }

}
