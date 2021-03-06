package com.example.sumit.WordGuessing.commons;

import java.util.Locale;

public abstract class DurationFormatter {

    public static String fromInteger(int duration) {
        if (duration <= 0)
            return "00:00";

        int secs = duration % 60;
        int min = duration / 60;

        return String.format(Locale.US, "%02d:%02d", min, secs);
    }

}
