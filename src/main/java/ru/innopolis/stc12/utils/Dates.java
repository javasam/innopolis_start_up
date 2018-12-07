package ru.innopolis.stc12.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;

public final class Dates {
    private Dates() {
        throw new AssertionError();
    }

    public static Date lastDate() {
        Calendar calendar = getInstance();
        calendar.set(2999, Calendar.DECEMBER, 31);
        return calendar.getTime();
    }

    public static int yearsBetween(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
