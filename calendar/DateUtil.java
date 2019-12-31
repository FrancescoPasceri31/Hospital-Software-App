// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
    protected Date minSelectableDate;
    protected Date maxSelectableDate;
    protected Date defaultMinSelectableDate;
    protected Date defaultMaxSelectableDate;
    
    public DateUtil() {
        final Calendar tmpCalendar = Calendar.getInstance();
        tmpCalendar.set(1, 0, 1, 1, 1);
        this.defaultMinSelectableDate = tmpCalendar.getTime();
        this.minSelectableDate = this.defaultMinSelectableDate;
        tmpCalendar.set(9999, 0, 1, 1, 1);
        this.defaultMaxSelectableDate = tmpCalendar.getTime();
        this.maxSelectableDate = this.defaultMaxSelectableDate;
    }
    
    public void setSelectableDateRange(final Date min, final Date max) {
        if (min == null) {
            this.minSelectableDate = this.defaultMinSelectableDate;
        }
        else {
            this.minSelectableDate = min;
        }
        if (max == null) {
            this.maxSelectableDate = this.defaultMaxSelectableDate;
        }
        else {
            this.maxSelectableDate = max;
        }
        if (this.maxSelectableDate.before(this.minSelectableDate)) {
            this.minSelectableDate = this.defaultMinSelectableDate;
            this.maxSelectableDate = this.defaultMaxSelectableDate;
        }
    }
    
    public Date setMaxSelectableDate(final Date max) {
        if (max == null) {
            this.maxSelectableDate = this.defaultMaxSelectableDate;
        }
        else {
            this.maxSelectableDate = max;
        }
        return this.maxSelectableDate;
    }
    
    public Date setMinSelectableDate(final Date min) {
        if (min == null) {
            this.minSelectableDate = this.defaultMinSelectableDate;
        }
        else {
            this.minSelectableDate = min;
        }
        return this.minSelectableDate;
    }
    
    public Date getMaxSelectableDate() {
        return this.maxSelectableDate;
    }
    
    public Date getMinSelectableDate() {
        return this.minSelectableDate;
    }
    
    public boolean checkDate(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        final Calendar minCal = Calendar.getInstance();
        minCal.setTime(this.minSelectableDate);
        minCal.set(11, 0);
        minCal.set(12, 0);
        minCal.set(13, 0);
        minCal.set(14, 0);
        final Calendar maxCal = Calendar.getInstance();
        maxCal.setTime(this.maxSelectableDate);
        maxCal.set(11, 0);
        maxCal.set(12, 0);
        maxCal.set(13, 0);
        maxCal.set(14, 0);
        return !calendar.before(minCal) && !calendar.after(maxCal);
    }
}
