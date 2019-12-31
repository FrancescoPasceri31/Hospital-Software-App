// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.awt.Color;
import java.util.Date;

public interface IDateEvaluator
{
    boolean isSpecial(final Date p0);
    
    Color getSpecialForegroundColor();
    
    Color getSpecialBackroundColor();
    
    String getSpecialTooltip();
    
    boolean isInvalid(final Date p0);
    
    Color getInvalidForegroundColor();
    
    Color getInvalidBackroundColor();
    
    String getInvalidTooltip();
}
