// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.awt.Color;
import java.util.Date;

public class MinMaxDateEvaluator implements IDateEvaluator
{
    private DateUtil dateUtil;
    
    public MinMaxDateEvaluator() {
        this.dateUtil = new DateUtil();
    }
    
    @Override
    public boolean isSpecial(final Date date) {
        return false;
    }
    
    @Override
    public Color getSpecialForegroundColor() {
        return null;
    }
    
    @Override
    public Color getSpecialBackroundColor() {
        return null;
    }
    
    @Override
    public String getSpecialTooltip() {
        return null;
    }
    
    @Override
    public boolean isInvalid(final Date date) {
        return !this.dateUtil.checkDate(date);
    }
    
    @Override
    public Color getInvalidForegroundColor() {
        return null;
    }
    
    @Override
    public Color getInvalidBackroundColor() {
        return null;
    }
    
    @Override
    public String getInvalidTooltip() {
        return null;
    }
    
    public Date setMaxSelectableDate(final Date max) {
        return this.dateUtil.setMaxSelectableDate(max);
    }
    
    public Date setMinSelectableDate(final Date min) {
        return this.dateUtil.setMinSelectableDate(min);
    }
    
    public Date getMaxSelectableDate() {
        return this.dateUtil.getMaxSelectableDate();
    }
    
    public Date getMinSelectableDate() {
        return this.dateUtil.getMinSelectableDate();
    }
}
